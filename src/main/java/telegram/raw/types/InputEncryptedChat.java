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

public class InputEncryptedChat extends TlObject {

    public static final int ID = -247351839;

    public int chat_id;
	public long access_hash;

    public InputEncryptedChat(int chat_id, long access_hash) {
        this.chat_id = chat_id;
		this.access_hash = access_hash;
    }

    public static InputEncryptedChat read(ByteArrayInputStream bytes) throws IOException {
        int chat_id = IntPrimitive.read(bytes).getValue();
		long access_hash = LongPrimitive.read(bytes).getValue();
		
		return new InputEncryptedChat(chat_id, access_hash);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.chat_id).write());
		bOut.write(new LongPrimitive(this.access_hash).write());
		
		return bOut.toByteArray();
    }
}
