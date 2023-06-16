package telegram.raw.functions.updates;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GetState extends TlObject {

    private final int ID = 0xedd4882a;

    public GetState() {}

    public static GetState read(ByteArrayInputStream bytes) {
        return new GetState();
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        bOut.write(new IntPrimitive(this.ID).write());

        return bOut.toByteArray();
    }
}
