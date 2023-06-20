package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ResPQ extends TlObject {

    public static final int ID = 0x05162463;

    public BigInteger nonce;
    public BigInteger server_nonce;
    public byte[] pq;
    public ArrayList<Long> public_key_fingerprints;


    public ResPQ(BigInteger nonce, BigInteger server_nonce, byte[] pq, ArrayList<Long> public_key_fingerprints){
        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.pq = pq;
        this.public_key_fingerprints = public_key_fingerprints;
    }

    public static ResPQ read(ByteArrayInputStream bytes) throws IOException {

        BigInteger nonce = IntBigPrimitive.read(bytes).getValue();
        BigInteger server_nonce = IntBigPrimitive.read(bytes).getValue();
        byte[] pq = BytesPrimitive.read(bytes).getValue();

        ArrayList<Long> public_key_fingerprints = ((VectorPrimitive)TlObject.read(bytes)).asLong();

        return new ResPQ(nonce, server_nonce, pq, public_key_fingerprints);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
