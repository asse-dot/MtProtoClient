package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityPre extends TlObject {

    public static final int ID = 0x73924be0;

    public int offset;
    public int length;
    public String language;


    public MessageEntityPre(int offset, int length, String language) {
        this.offset = offset;
        this.length = length;
        this.language = language;
    }

    public static MessageEntityPre read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();
        String language = StringPrimitive.read(bytes).getValue();

        return new MessageEntityPre(offset, length, language);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
