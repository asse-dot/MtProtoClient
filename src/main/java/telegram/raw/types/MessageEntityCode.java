package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityCode extends TlObject {

    public static final int ID = 0x28a20571;

    public int offset;
    public int length;

    public MessageEntityCode(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntityCode read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntityCode(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
