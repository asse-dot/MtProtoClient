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

public class DataJSON extends TlObject {

    public static final int ID = 2104790276;

    public String data;

    public DataJSON(String data) {
        this.data = data;
    }

    public static DataJSON read(ByteArrayInputStream bytes) throws IOException {
        String data = StringPrimitive.read(bytes).getValue();
		
		return new DataJSON(data);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.data).write());
		
		return bOut.toByteArray();
    }
}
