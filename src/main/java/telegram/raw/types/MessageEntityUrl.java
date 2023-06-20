package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityUrl extends TlObject {

    public static final int ID = 0x6ed02538;

    public int offset;
    public int length;

    public MessageEntityUrl(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntityUrl read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntityUrl(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
