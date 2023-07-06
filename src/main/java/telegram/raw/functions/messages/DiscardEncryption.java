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

public class DiscardEncryption extends TlObject {

    public static final int ID = -208425312;

    public boolean delete_history;
	public int chat_id;

    public DiscardEncryption(boolean delete_history, int chat_id) {
        this.delete_history = delete_history;
		this.chat_id = chat_id;
    }

    public static DiscardEncryption read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean delete_history = (flags & (1 << 0)) != 0;
		int chat_id = IntPrimitive.read(bytes).getValue();
		
		return new DiscardEncryption(delete_history, chat_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.delete_history ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new IntPrimitive(this.chat_id).write());
		
		return bOut.toByteArray();
    }
}
