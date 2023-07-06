//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.messages;

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

public class DeleteChat extends TlObject {

    public static final int ID = 1540419152;

    public long chat_id;

    public DeleteChat(long chat_id) {
        this.chat_id = chat_id;
    }

    public static DeleteChat read(ByteArrayInputStream bytes) throws IOException {
        long chat_id = LongPrimitive.read(bytes).getValue();
		
		return new DeleteChat(chat_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.chat_id).write());
		
		return bOut.toByteArray();
    }
}
