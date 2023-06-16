package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class ReqDHParams extends TlObject {
    // 0xd712e4be
    private final int ID = 0xd712e4be;

    public BigInteger nonce;
    public BigInteger server_nonce;
    public byte[] p;
    public byte[] q;
    public long public_key_fingerprint;
    public byte[] encrypted_data;

    public ReqDHParams(BigInteger nonce, BigInteger server_nonce, byte[] p, byte[] q, long public_key_fingerprint,
                       byte[] encrypted_data) {

        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.p = p;
        this.q = q;
        this.public_key_fingerprint = public_key_fingerprint;
        this.encrypted_data = encrypted_data;

    }


    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new IntBigPrimitive(this.nonce).write());
        bOut.write(new IntBigPrimitive(this.server_nonce).write());
        bOut.write(new BytesPrimitive(this.p).write());
        bOut.write(new BytesPrimitive(this.q).write());
        bOut.write(new LongPrimitive(this.public_key_fingerprint).write());
        bOut.write(new BytesPrimitive(this.encrypted_data).write());

        return bOut.toByteArray();

    }
}
