package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MessageEntityBotCommand extends TlObject {

    public static final int ID= 0x6cef8ac7;

    public int offset;
    public int length;

    public MessageEntityBotCommand(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public static MessageEntityBotCommand read(ByteArrayInputStream bytes) throws IOException {

        int offset = IntPrimitive.read(bytes).getValue();
        int length = IntPrimitive.read(bytes).getValue();

        return new MessageEntityBotCommand(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
