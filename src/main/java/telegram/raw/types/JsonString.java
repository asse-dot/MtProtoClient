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

public class JsonString extends TlObject {

    public static final int ID = -1222740358;

    public String value;

    public JsonString(String value) {
        this.value = value;
    }

    public static JsonString read(ByteArrayInputStream bytes) throws IOException {
        String value = StringPrimitive.read(bytes).getValue();
		
		return new JsonString(value);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.value).write());
		
		return bOut.toByteArray();
    }
}
