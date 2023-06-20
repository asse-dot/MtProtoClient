package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityCustomEmoji extends TlObject {

    public static final int ID = 0xc8cf05f8;

    public int offset;
    public int length;
    public long document_id;

    public MessageEntityCustomEmoji(int offset, int length, long document_id) {
        this.offset = offset;
        this.length = length;
        this.document_id = document_id;
    }

    public static MessageEntityCustomEmoji read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();
        long document_id = LongPrimitive.read(bytes).getValue();

        return new MessageEntityCustomEmoji(offset, length, document_id);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
