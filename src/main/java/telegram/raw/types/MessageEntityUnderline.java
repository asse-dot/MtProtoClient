package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityUnderline extends TlObject {

    public static final int ID = 0x9c4e7e8b;

    public int offset;
    public int length;

    public MessageEntityUnderline(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntityUnderline read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntityUnderline(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
