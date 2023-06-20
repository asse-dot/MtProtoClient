package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityTextUrl extends TlObject {

    public static final int ID = 0x76a6d327;

    public int offset;
    public int length;
    public String url;

    public MessageEntityTextUrl(int offset, int length, String url) {
        this.offset = offset;
        this.length = length;
        this.url = url;
    }

    public static MessageEntityTextUrl read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();
        String url = StringPrimitive.read(bytes).getValue();

        return new MessageEntityTextUrl(offset, length, url);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
