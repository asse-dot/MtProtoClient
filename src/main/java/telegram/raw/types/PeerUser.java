package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PeerUser extends TlObject {

    public static final int ID = 0x59511722;

    public long user_id;

    public PeerUser(long user_id) {
        this.user_id = user_id;
    }

    public static PeerUser read(ByteArrayInputStream bytes) throws IOException {
        long user_id = LongPrimitive.read(bytes).getValue();
        return new PeerUser(user_id);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
