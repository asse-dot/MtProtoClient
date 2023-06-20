package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntBigPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class ReqPqMulti extends TlObject {


    public static final int ID = 0xbe7e8ef1;
    public final BigInteger nonce; //128 bit

    public ReqPqMulti(BigInteger nonce) {
        this.nonce = nonce;
    }

    public static ReqPqMulti read(ByteArrayInputStream bytes) throws IOException {

        BigInteger nonce = IntBigPrimitive.read(bytes).getValue();

        return new ReqPqMulti(nonce);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(ID).write());
        bOut.write(new IntBigPrimitive(this.nonce).write());
        
        return bOut.toByteArray();

    }


}
