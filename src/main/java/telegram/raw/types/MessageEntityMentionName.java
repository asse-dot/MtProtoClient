package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityMentionName extends TlObject {

    public static final int ID = 0xdc7b1140;

    public int offset;
    public int length;
    public long user_id;

    public MessageEntityMentionName(int offset, int length, long user_id) {
        this.offset = offset;
        this.length = length;
        this.user_id = user_id;
    }

    public static MessageEntityMentionName read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();
        long user_id = LongPrimitive.read(bytes).getValue();

        return new MessageEntityMentionName(offset, length, user_id);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
