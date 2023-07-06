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

public class SetTyping extends TlObject {

    public static final int ID = 1486110434;

    public TlObject peer;
	public int top_msg_id;
	public TlObject action;

    public SetTyping(TlObject peer, int top_msg_id, TlObject action) {
        this.peer = peer;
		this.top_msg_id = top_msg_id;
		this.action = action;
    }

    public static SetTyping read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		TlObject peer = TlObject.read(bytes);
		int top_msg_id = (flags & (1 << 0)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		TlObject action = TlObject.read(bytes);
		
		return new SetTyping(peer, top_msg_id, action);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.top_msg_id != 0) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.peer.write());
		if(this.top_msg_id != 0)
			bOut.write(new IntPrimitive(this.top_msg_id).write());
		bOut.write(this.action.write());
		
		return bOut.toByteArray();
    }
}
