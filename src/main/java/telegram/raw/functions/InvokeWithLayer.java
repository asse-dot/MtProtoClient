package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InvokeWithLayer extends TlObject{

    //0xda9b0d0d
    private final int ID = 0xda9b0d0d;

    public int layer;
    public TlObject query;

    public InvokeWithLayer(int layer, TlObject query) {
        this.layer = layer;
        this.query = query;
    }


    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new IntPrimitive(this.layer).write());
        bOut.write(this.query.write());


        return bOut.toByteArray();
    }
}
