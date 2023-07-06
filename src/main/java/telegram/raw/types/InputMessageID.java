//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types;

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

public class InputMessageID extends TlObject {

    public static final int ID = -1502174430;

    public int id;

    public InputMessageID(int id) {
        this.id = id;
    }

    public static InputMessageID read(ByteArrayInputStream bytes) throws IOException {
        int id = IntPrimitive.read(bytes).getValue();
		
		return new InputMessageID(id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.id).write());
		
		return bOut.toByteArray();
    }
}
