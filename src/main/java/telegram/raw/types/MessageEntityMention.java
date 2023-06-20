package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityMention extends TlObject {

    public static final int ID = 0xfa04579d;

    public int offset;
    public int length;

    public MessageEntityMention(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntityMention read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntityMention(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
