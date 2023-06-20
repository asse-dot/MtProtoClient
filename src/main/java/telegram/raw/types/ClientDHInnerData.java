package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class ClientDHInnerData extends TlObject {

    public static final int ID = 0x6643b654;

    public BigInteger nonce;
    public BigInteger server_nonce;
    public long retry_id;
    public byte[] g_b;

    public ClientDHInnerData(BigInteger nonce, BigInteger server_nonce, long retry_id, byte[] g_b) {

        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.retry_id = retry_id;
        this.g_b = g_b;

    }

    //TODO read

    @Override
    public byte[] write() throws IOException {

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        bOut.write(new IntPrimitive(ID).write());
        bOut.write(new IntBigPrimitive(this.nonce).write());
        bOut.write(new IntBigPrimitive(this.server_nonce).write());
        bOut.write(new LongPrimitive(this.retry_id).write());
        bOut.write(new BytesPrimitive(this.g_b).write());

        return bOut.toByteArray();
    }
}
