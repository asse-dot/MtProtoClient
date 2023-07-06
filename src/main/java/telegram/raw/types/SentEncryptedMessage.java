//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.messages;

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

public class SentEncryptedMessage extends TlObject {

    public static final int ID = 1443858741;

    public int date;

    public SentEncryptedMessage(int date) {
        this.date = date;
    }

    public static SentEncryptedMessage read(ByteArrayInputStream bytes) throws IOException {
        int date = IntPrimitive.read(bytes).getValue();
		
		return new SentEncryptedMessage(date);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.date).write());
		
		return bOut.toByteArray();
    }
}
