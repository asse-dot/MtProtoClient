package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityPhone extends TlObject{

    public static final int ID = 0x9b69e34b;

    public int offset;
    public int length;

    public MessageEntityPhone(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntityPhone read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntityPhone(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
