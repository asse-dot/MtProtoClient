package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateNewMessage extends TlObject {

    public static final int ID = 0x1f2b0afd;

    public TlObject message;
    public int pts;
    public int pts_count;

    public UpdateNewMessage(TlObject message, int pts, int pts_count) {
        this.message = message;
        this.pts = pts;
        this.pts_count = pts_count;
    }

    public static UpdateNewMessage read(ByteArrayInputStream bytes) throws IOException {

        TlObject message = TlObject.read(bytes);
        int pts = IntPrimitive.read(bytes).getValue();
        int pts_count = IntPrimitive.read(bytes).getValue();

        return new UpdateNewMessage(message, pts, pts_count);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
