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

public class MessageActionChannelMigrateFrom extends TlObject {

    public static final int ID = -365344535;

    public String title;
	public long chat_id;

    public MessageActionChannelMigrateFrom(String title, long chat_id) {
        this.title = title;
		this.chat_id = chat_id;
    }

    public static MessageActionChannelMigrateFrom read(ByteArrayInputStream bytes) throws IOException {
        String title = StringPrimitive.read(bytes).getValue();
		long chat_id = LongPrimitive.read(bytes).getValue();
		
		return new MessageActionChannelMigrateFrom(title, chat_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.title).write());
		bOut.write(new LongPrimitive(this.chat_id).write());
		
		return bOut.toByteArray();
    }
}
