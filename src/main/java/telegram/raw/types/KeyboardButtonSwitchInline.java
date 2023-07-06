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

public class KeyboardButtonSwitchInline extends TlObject {

    public static final int ID = -1816527947;

    public boolean same_peer;
	public String text;
	public String query;
	public ArrayList<TlObject> peer_types;

    public KeyboardButtonSwitchInline(boolean same_peer, String text, String query, ArrayList<TlObject> peer_types) {
        this.same_peer = same_peer;
		this.text = text;
		this.query = query;
		this.peer_types = peer_types;
    }

    public static KeyboardButtonSwitchInline read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean same_peer = (flags & (1 << 0)) != 0;
		String text = StringPrimitive.read(bytes).getValue();
		String query = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> peer_types = (flags & (1 << 1)) != 0 ?  ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;
		
		return new KeyboardButtonSwitchInline(same_peer, text, query, peer_types);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.same_peer ? (1 << 0) : 0;
		flags |= (this.peer_types != null) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new StringPrimitive(this.text).write());
		bOut.write(new StringPrimitive(this.query).write());
		if(this.peer_types != null)
			bOut.write(new VectorPrimitive(this.peer_types).write());
		
		return bOut.toByteArray();
    }
}
