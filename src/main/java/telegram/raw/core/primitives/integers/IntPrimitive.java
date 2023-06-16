package telegram.raw.core.primitives.integers;

import telegram.raw.core.TlObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class IntPrimitive extends TlObject {
    
    private int value;
    
    public IntPrimitive(int value) {
        
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static IntPrimitive read(ByteArrayInputStream bytes) throws IOException {

        byte[] wrapper = new byte[4];
        bytes.read(wrapper);
        return new IntPrimitive(((wrapper[3] & 0xFF) << 24) | ((wrapper[2] & 0xFF) << 16) | ((wrapper[1] & 0xFF) << 8) | (wrapper[0] & 0xFF));
    }
    
    public byte[] write() {

        return new byte[]{
                (byte) (this.value),
                (byte) (this.value >> 8),
                (byte) (this.value >> 16),
                (byte) (this.value >> 24)
        };
    }
}
