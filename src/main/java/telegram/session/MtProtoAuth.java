package telegram.session;

import telegram.Utils;
import telegram.connection.Connection;
import telegram.crypto.AES;
import telegram.crypto.Prime;
import telegram.crypto.RSA;
import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;
import telegram.raw.functions.ReqDHParams;
import telegram.raw.functions.ReqPqMulti;
import telegram.raw.functions.SetClientDHParams;
import telegram.raw.types.*;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.swing.text.Utilities;
import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class MtProtoAuth {

    private Connection connection;

    public MtProtoAuth() {
        this.connection = new Connection("TCP/0");
    }

    private static byte[] calculateTmpAesKey(MessageDigest hashDigest, byte[] new_nonce, byte[] server_nonce) {

        byte[] digest_a = hashDigest.digest(Utils.addArray(new_nonce, server_nonce));
        byte[] digest_b = Utils.subStr(hashDigest.digest(Utils.addArray(server_nonce, new_nonce)), 0, 12);

        return Utils.addArray(digest_a, digest_b);

    }

    private static byte[] calculateTmpAesIv(MessageDigest hashDigest, byte[] new_nonce, byte[] server_nonce) {
        byte[] digest_a = Utils.subStr(hashDigest.digest(Utils.addArray(server_nonce, new_nonce)), 12, 8);
        byte[] digest_b = hashDigest.digest(Utils.addArray(new_nonce, new_nonce));

        byte[] digest_sum = Utils.addArray(digest_a, digest_b);

        return Utils.addArray(digest_sum, Utils.subStr(new_nonce, 0, 4));
    }

    private byte[] pack(TlObject data) throws IOException {
        byte[] tlPack = data.write();

        int length_data = tlPack.length;
        long msgID_data = (System.currentTimeMillis() / 1000L) * (long)Math.pow(2, 32);
        byte[] packet = new byte[20 + length_data];
        byte[] length =  new IntPrimitive(length_data).write();
        byte[] msgID = new LongPrimitive(msgID_data).write();

        System.arraycopy(new byte[8],  0, packet, 0, 8); //auth_key_id
        System.arraycopy(msgID, 0, packet, 8, 8); //msgID
        System.arraycopy(length, 0, packet, 16, 4); //message_length
        System.arraycopy(tlPack, 0, packet, 20, length_data); //TlObject
        return packet;
    }


    private TlObject unpack(ByteArrayInputStream bOut) throws IOException {
        bOut.skip(20); //skip authkey_id, msgID and message_length
        return TlObject.read(bOut);
    }


    private TlObject invoke(TlObject data) throws IOException {
        byte[] packet = pack(data);
        this.connection.send(packet);
        byte[] response = this.connection.read();
        ByteArrayInputStream test = new ByteArrayInputStream(response);
        test.skip(20);
        System.out.println(Integer.toHexString(IntPrimitive.read(test).getValue()));
        return unpack(new ByteArrayInputStream(response));
    }

    public byte[] createAuthKey() throws IOException, NoSuchAlgorithmException{
        this.connection.connect();
        MessageDigest sha1Hash = MessageDigest.getInstance("SHA-1");
        byte[] nonce = new byte[16];
        byte[] new_nonce = new byte[32];
        
        Random random = new Random();

        random.nextBytes(nonce);
        ResPQ res_pq = (ResPQ) this.invoke(new ReqPqMulti(new BigInteger(nonce)));
        byte[] server_nonce = res_pq.server_nonce.toByteArray();
        //per adesso prendo solo e soltanto il primo elemento, che corrisponde al modulo
        //e all'esponente nella classe RSA. Poi si amplia per più chiavi.
        //TODO
        long public_key_fingerprint = res_pq.public_key_fingerprints.get(0);

        long pq = ByteBuffer.wrap(res_pq.pq).order(ByteOrder.BIG_ENDIAN).getLong();
        int decompose = Prime.decompose(pq);
        int decompose_d = (int)(pq / decompose);

        int p = Math.min(decompose, decompose_d);
        int q = Math.max(decompose, decompose_d);


        random.nextBytes(new_nonce);
        byte[] pq_inner_data = new PQInnerData(res_pq.pq, Utils.toByteBigEndian(p), Utils.toByteBigEndian(q), res_pq.nonce, res_pq.server_nonce, new BigInteger( new_nonce))
                .write();

        byte[] sha1 = sha1Hash.digest(pq_inner_data);
        byte[] data = new byte[255];
        int padding_length = 255 - ((sha1.length + pq_inner_data.length) % 255);

        byte[] padding = new byte[padding_length];
        random.nextBytes(padding);

        System.arraycopy(sha1, 0, data, 0, sha1.length);
        System.arraycopy(pq_inner_data, 0, data, sha1.length, pq_inner_data.length);
        System.arraycopy(padding, 0, data, sha1.length + pq_inner_data.length, padding.length);
        byte[] encrypted_data = RSA.encrypt(data);

        ServerDHParamsOk serverDHParamsOk = (ServerDHParamsOk) this.invoke(new ReqDHParams(res_pq.nonce, res_pq.server_nonce, Utils.toByteBigEndian(p),
                Utils.toByteBigEndian(q), public_key_fingerprint, encrypted_data));

        byte[] temp_aes_key = calculateTmpAesKey(sha1Hash, new_nonce, server_nonce);
        byte[] temp_aes_iv = calculateTmpAesIv(sha1Hash, new_nonce, server_nonce);

        AES aes = new AES(temp_aes_key, temp_aes_iv);
        byte[] answer_with_hash = aes.decrypt(serverDHParamsOk.encrypted_answer);
        byte[] answer = Utils.subStr(answer_with_hash, 20, answer_with_hash.length - 20);

        ServerDHInnerData serverDHInnerData = (ServerDHInnerData) TlObject.read(new ByteArrayInputStream(answer));

        byte[] bytes_b = new byte[256]; //random b 2048 bit
        random.nextBytes(bytes_b);
        
        int retry_id = 0; //idk now
        BigInteger g_a = new BigInteger(1, serverDHInnerData.g_a);
        BigInteger dh_prime = new BigInteger(1, serverDHInnerData.dh_prime);
        BigInteger b = new BigInteger(1, bytes_b);
        BigInteger g = BigInteger.valueOf(serverDHInnerData.g);

        byte[] g_b = g.modPow(b, dh_prime).toByteArray(); 
        
        byte[] client_dh_inner_data = new ClientDHInnerData(new BigInteger(nonce), new BigInteger(server_nonce), retry_id, g_b)
                .write();
        
        sha1 = sha1Hash.digest(client_dh_inner_data);
        padding_length = 16 - ((sha1.length + client_dh_inner_data.length) % 16);
        padding = new byte[padding_length];
        
        data = new byte[padding_length + sha1.length + client_dh_inner_data.length];

        System.arraycopy(sha1, 0, data, 0, sha1.length);
        System.arraycopy(client_dh_inner_data, 0, data, sha1.length, client_dh_inner_data.length);
        System.arraycopy(padding, 0, data, sha1.length + client_dh_inner_data.length, padding.length);

        encrypted_data = aes.encrypt(data);
        this.invoke(new SetClientDHParams(new BigInteger(nonce), new BigInteger(server_nonce), encrypted_data));

        byte[] auth_key = g_a.modPow(b, dh_prime).toByteArray();
        if(auth_key.length > 256) {
            auth_key = Utils.subStr(auth_key, 1, auth_key.length -1);
        }

        this.connection.close();
        return auth_key;
    }


}
