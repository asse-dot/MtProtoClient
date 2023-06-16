package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class PQInnerData extends TlObject {
    //0x83c95aec
    private final int ID = 0x83c95aec;

    public byte[] pq;
    public byte[] p;
    public byte[] q;
    public BigInteger nonce; //128 bit
    public BigInteger server_nonce; //128 bit;
    public BigInteger new_nonce; //256 bit

    public PQInnerData(byte[] pq, byte[] p, byte[] q, BigInteger nonce,
                       BigInteger server_nonce, BigInteger new_nonce) {

        this.pq = pq;
        this.p = p;
        this.q = q;
        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.new_nonce = new_nonce;
    }


    //TODO

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new BytesPrimitive(this.pq).write());
        bOut.write(new BytesPrimitive(this.p).write());
        bOut.write(new BytesPrimitive(this.q).write());
        bOut.write(new IntBigPrimitive(this.nonce).write());
        bOut.write(new IntBigPrimitive(this.server_nonce).write());
        bOut.write(new IntBigPrimitive(this.new_nonce).write());

        return bOut.toByteArray();
    }
}
