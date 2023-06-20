package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InputUser extends TlObject {

    public static final int ID = 0xf21158c6;

    public long user_id;
    public long access_hash;


    public InputUser(long user_id, long access_hash) {
        this.user_id = user_id;
        this.access_hash = access_hash;
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(ID).write());
        bOut.write(new LongPrimitive(this.user_id).write());
        bOut.write(new LongPrimitive(this.access_hash).write());

        return bOut.toByteArray();
    }
}
