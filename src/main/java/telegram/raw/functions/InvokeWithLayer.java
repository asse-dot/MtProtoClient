//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class InvokeWithLayer extends TlObject {

    public static final int ID = 0xda9b0d0d;

    public int layer;
	public TlObject query;

    public InvokeWithLayer(int layer, TlObject query) {
        this.layer = layer;
		this.query = query;
    }

    public static InvokeWithLayer read(ByteArrayInputStream bytes) throws IOException {
        int layer = IntPrimitive.read(bytes).getValue();
		TlObject query = TlObject.read(bytes);
		
		return new InvokeWithLayer(layer, query);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.layer).write());
		bOut.write(this.query.write());
		
		return bOut.toByteArray();
    }
}
