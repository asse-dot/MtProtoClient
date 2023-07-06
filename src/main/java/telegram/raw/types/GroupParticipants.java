//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.phone;

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

public class GroupParticipants extends TlObject {

    public static final int ID = -193506890;

    public int count;
	public ArrayList<TlObject> participants;
	public String next_offset;
	public ArrayList<TlObject> chats;
	public ArrayList<TlObject> users;
	public int version;

    public GroupParticipants(int count, ArrayList<TlObject> participants, String next_offset, ArrayList<TlObject> chats, ArrayList<TlObject> users, int version) {
        this.count = count;
		this.participants = participants;
		this.next_offset = next_offset;
		this.chats = chats;
		this.users = users;
		this.version = version;
    }

    public static GroupParticipants read(ByteArrayInputStream bytes) throws IOException {
        int count = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> participants = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		String next_offset = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> chats = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		int version = IntPrimitive.read(bytes).getValue();
		
		return new GroupParticipants(count, participants, next_offset, chats, users, version);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.count).write());
		bOut.write(new VectorPrimitive(this.participants).write());
		bOut.write(new StringPrimitive(this.next_offset).write());
		bOut.write(new VectorPrimitive(this.chats).write());
		bOut.write(new VectorPrimitive(this.users).write());
		bOut.write(new IntPrimitive(this.version).write());
		
		return bOut.toByteArray();
    }
}
