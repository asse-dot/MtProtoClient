package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class ServerDHInnerData extends TlObject {

    public static final int ID = 0xb5890dba;

    public BigInteger nonce;
    public BigInteger server_nonce;
    public int g;
    public byte[] dh_prime;
    public byte[] g_a;
    public int server_time;

    public ServerDHInnerData(BigInteger nonce, BigInteger server_nonce, int g, byte[] dh_prime, byte[] g_a,
                             int server_time) {

        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.g = g;
        this.dh_prime = dh_prime;
        this.g_a = g_a;
        this.server_time = server_time;

    }

    public static ServerDHInnerData read(ByteArrayInputStream bytes) throws IOException {

        BigInteger nonce = IntBigPrimitive.read(bytes).getValue();
        BigInteger server_nonce = IntBigPrimitive.read(bytes).getValue();
        int g = IntPrimitive.read(bytes).getValue();
        byte[] dh_prime = BytesPrimitive.read(bytes).getValue();
        byte[] g_a = BytesPrimitive.read(bytes).getValue();
        int server_time = IntPrimitive.read(bytes).getValue();

        return new ServerDHInnerData(nonce, server_nonce, g, dh_prime, g_a, server_time);
    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
