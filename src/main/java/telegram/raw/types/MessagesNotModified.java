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

public class MessagesNotModified extends TlObject {

    public static final int ID = 1951620897;

    public int count;

    public MessagesNotModified(int count) {
        this.count = count;
    }

    public static MessagesNotModified read(ByteArrayInputStream bytes) throws IOException {
        int count = IntPrimitive.read(bytes).getValue();
		
		return new MessagesNotModified(count);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.count).write());
		
		return bOut.toByteArray();
    }
}
