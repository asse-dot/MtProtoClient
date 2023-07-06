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

public class ChatForbidden extends TlObject {

    public static final int ID = 1704108455;

    public long id;
	public String title;

    public ChatForbidden(long id, String title) {
        this.id = id;
		this.title = title;
    }

    public static ChatForbidden read(ByteArrayInputStream bytes) throws IOException {
        long id = LongPrimitive.read(bytes).getValue();
		String title = StringPrimitive.read(bytes).getValue();
		
		return new ChatForbidden(id, title);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.id).write());
		bOut.write(new StringPrimitive(this.title).write());
		
		return bOut.toByteArray();
    }
}
