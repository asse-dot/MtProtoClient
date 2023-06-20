package telegram.crypto;

import telegram.Utils;
import telegram.raw.core.Message;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class MtProto {

    private static Random random = new Random();
    private static MessageDigest sha256Hash;

    static {
        try {
            sha256Hash = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] pack(Message message, long salt, byte[] session_id, byte[] auth_key_id, byte[] auth_key) throws IOException{
        byte[] data = new byte[16 + message.getLength()]; //salt (8) + session_id(8)

        System.arraycopy(new LongPrimitive(salt).write(), 0, data, 0, 8);
        System.arraycopy(session_id, 0, data, 8, 8);
        System.arraycopy(message.write(), 0, data,16, message.getLength());

        byte[] padding = new byte[(16 - (data.length + 12) % 16) + 12];
        random.nextBytes(padding);
        byte[] data_with_padding = Utils.addArray(data, padding);
        byte[] msg_key_large = sha256Hash.digest(Utils.addArray(Utils.subStr(auth_key, 88, 32), data_with_padding));
        byte[] msg_key = Utils.subStr(msg_key_large, 8, 16);

        byte[] sha256_a = sha256Hash.digest(Utils.addArray(msg_key, Utils.subStr(auth_key, 0, 36)));
        byte[] sha256_b = sha256Hash.digest(Utils.addArray(Utils.subStr(auth_key, 40, 36), msg_key));

        byte[] aes_key = Utils.addArray(Utils.addArray(Utils.subStr(sha256_a, 0, 8), Utils.subStr(sha256_b, 8, 16)),
                Utils.subStr(sha256_a, 24, 8));

        byte[] aes_iv = Utils.addArray(Utils.addArray(Utils.subStr(sha256_b, 0, 8), Utils.subStr(sha256_a, 8, 16)),
                Utils.subStr(sha256_b, 24, 8));

        AES aes = new AES(aes_key, aes_iv);

        byte[] first = Utils.addArray(auth_key_id, msg_key);
        byte[] encrypted_data = aes.encrypt(data_with_padding);
        return Utils.addArray(first, encrypted_data);
    }

    //TODO unpack
    public static Message unpack(byte[] data, byte[] auth_key) throws IOException {

        byte[] msg_key = Utils.subStr(data, 8, 16);

        byte[] sha256_a = sha256Hash.digest(Utils.addArray(msg_key, Utils.subStr(auth_key, 8, 36)));
        byte[] sha256_b = sha256Hash.digest(Utils.addArray(Utils.subStr(auth_key, 48, 36), msg_key));

        byte[] aes_key = Utils.addArray(Utils.addArray(Utils.subStr(sha256_a, 0, 8), Utils.subStr(sha256_b, 8, 16)),
                Utils.subStr(sha256_a, 24, 8));

        byte[] aes_iv = Utils.addArray(Utils.addArray(Utils.subStr(sha256_b, 0, 8), Utils.subStr(sha256_a, 8, 16)),
                Utils.subStr(sha256_b, 24, 8));

        AES aes = new AES(aes_key, aes_iv);

        byte[] plaintext = aes.decrypt(Utils.subStr(data, 24, data.length - 24));
//        ByteArrayInputStream bIn1 = new ByteArrayInputStream(plaintext);
//        bIn1.skip(48);
//        try {
//            System.out.println(IntPrimitive.read(bIn1).getValue());
//            System.out.println(StringPrimitive.read(bIn1).getValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ByteArrayInputStream bIn = new ByteArrayInputStream(plaintext);
        bIn.skip(16);

        return Message.read(bIn);

    }

}
