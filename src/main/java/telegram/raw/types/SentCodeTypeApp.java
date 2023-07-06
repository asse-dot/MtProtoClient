//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.auth;

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

public class SentCodeTypeApp extends TlObject {

    public static final int ID = 1035688326;

    public int length;

    public SentCodeTypeApp(int length) {
        this.length = length;
    }

    public static SentCodeTypeApp read(ByteArrayInputStream bytes) throws IOException {
        int length = IntPrimitive.read(bytes).getValue();
		
		return new SentCodeTypeApp(length);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.length).write());
		
		return bOut.toByteArray();
    }
}
