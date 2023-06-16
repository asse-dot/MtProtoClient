package telegram.raw.core.primitives.integers;

import telegram.raw.core.TlObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class LongPrimitive extends TlObject {
    
    private long value;
    
    public LongPrimitive(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public static LongPrimitive read(ByteArrayInputStream bytes) throws IOException {
        byte[] wrapper = new byte[8];
        bytes.read(wrapper);
        return new LongPrimitive(ByteBuffer.wrap(wrapper).order(ByteOrder.LITTLE_ENDIAN).getLong());
    }
    
    public byte[] write() {
        return new byte[] {
                (byte)(this.value),
                (byte)(this.value >> 8),
                (byte)(this.value >> 16),
                (byte)(this.value >> 24),
                (byte)(this.value >> 32),
                (byte)(this.value >> 40),
                (byte)(this.value >> 48),
                (byte)(this.value >> 56),
        };
    }
}
