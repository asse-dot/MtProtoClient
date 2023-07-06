//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.updates;

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

public class DifferenceSlice extends TlObject {

    public static final int ID = -1459938943;

    public ArrayList<TlObject> new_messages;
	public ArrayList<TlObject> new_encrypted_messages;
	public ArrayList<TlObject> other_updates;
	public ArrayList<TlObject> chats;
	public ArrayList<TlObject> users;
	public TlObject intermediate_state;

    public DifferenceSlice(ArrayList<TlObject> new_messages, ArrayList<TlObject> new_encrypted_messages, ArrayList<TlObject> other_updates, ArrayList<TlObject> chats, ArrayList<TlObject> users, TlObject intermediate_state) {
        this.new_messages = new_messages;
		this.new_encrypted_messages = new_encrypted_messages;
		this.other_updates = other_updates;
		this.chats = chats;
		this.users = users;
		this.intermediate_state = intermediate_state;
    }

    public static DifferenceSlice read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> new_messages = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> new_encrypted_messages = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> other_updates = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> chats = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		TlObject intermediate_state = TlObject.read(bytes);
		
		return new DifferenceSlice(new_messages, new_encrypted_messages, other_updates, chats, users, intermediate_state);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.new_messages).write());
		bOut.write(new VectorPrimitive(this.new_encrypted_messages).write());
		bOut.write(new VectorPrimitive(this.other_updates).write());
		bOut.write(new VectorPrimitive(this.chats).write());
		bOut.write(new VectorPrimitive(this.users).write());
		bOut.write(this.intermediate_state.write());
		
		return bOut.toByteArray();
    }
}
