package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntitySpoiler extends TlObject{

    public static final int ID = 0x32ca960f;

    public int offset;
    public int length;

    public MessageEntitySpoiler(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntitySpoiler read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntitySpoiler(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
