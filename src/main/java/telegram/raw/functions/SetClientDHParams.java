package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.integers.IntBigPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;
import telegram.raw.types.ServerDHInnerData;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class SetClientDHParams extends TlObject {

    //TODO read
    public static final int ID = 0xf5045f1f;

    public BigInteger nonce;
    public BigInteger server_nonce;
    public byte[] encrypted_data;

    public SetClientDHParams(BigInteger nonce, BigInteger server_nonce, byte[] encrypted_data) {

        this.nonce = nonce;
        this.server_nonce = server_nonce;
        this.encrypted_data = encrypted_data;
    }

    @Override
    public byte[] write() throws IOException {


        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        bOut.write(new IntPrimitive(ID).write());
        bOut.write(new IntBigPrimitive(this.nonce).write());
        bOut.write(new IntBigPrimitive(this.server_nonce).write());
        bOut.write(new BytesPrimitive(this.encrypted_data).write());

        return bOut.toByteArray();
    }
}
