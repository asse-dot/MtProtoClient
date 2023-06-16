package telegram.raw.functions.help;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GetConfig extends TlObject {

    private final int ID = 0xc4f9186b;

    public GetConfig() {}


    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        bOut.write(new IntPrimitive(this.ID).write());

        return bOut.toByteArray();
    }
}
