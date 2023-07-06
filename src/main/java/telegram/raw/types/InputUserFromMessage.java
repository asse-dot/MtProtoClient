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

public class InputUserFromMessage extends TlObject {

    public static final int ID = 497305826;

    public TlObject peer;
	public int msg_id;
	public long user_id;

    public InputUserFromMessage(TlObject peer, int msg_id, long user_id) {
        this.peer = peer;
		this.msg_id = msg_id;
		this.user_id = user_id;
    }

    public static InputUserFromMessage read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		int msg_id = IntPrimitive.read(bytes).getValue();
		long user_id = LongPrimitive.read(bytes).getValue();
		
		return new InputUserFromMessage(peer, msg_id, user_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(new IntPrimitive(this.msg_id).write());
		bOut.write(new LongPrimitive(this.user_id).write());
		
		return bOut.toByteArray();
    }
}
