package telegram.raw.core.primitives.integers;

import telegram.raw.core.TlObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class IntBigPrimitive extends TlObject{

    private BigInteger value;

    public IntBigPrimitive(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

    public static IntBigPrimitive read(ByteArrayInputStream bytes) throws IOException {
        return IntBigPrimitive.read(bytes, 16);
    }

    public static IntBigPrimitive read(ByteArrayInputStream bytes, int size) throws IOException {
        byte[] wrapper = new byte[size];
        bytes.read(wrapper);
        return new IntBigPrimitive(new BigInteger(wrapper));
    }


    public byte[] write() {
        return value.toByteArray();
    }
}
