//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.channels;

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

public class ChannelParticipants extends TlObject {

    public static final int ID = -1699676497;

    public int count;
	public ArrayList<TlObject> participants;
	public ArrayList<TlObject> chats;
	public ArrayList<TlObject> users;

    public ChannelParticipants(int count, ArrayList<TlObject> participants, ArrayList<TlObject> chats, ArrayList<TlObject> users) {
        this.count = count;
		this.participants = participants;
		this.chats = chats;
		this.users = users;
    }

    public static ChannelParticipants read(ByteArrayInputStream bytes) throws IOException {
        int count = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> participants = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> chats = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new ChannelParticipants(count, participants, chats, users);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.count).write());
		bOut.write(new VectorPrimitive(this.participants).write());
		bOut.write(new VectorPrimitive(this.chats).write());
		bOut.write(new VectorPrimitive(this.users).write());
		
		return bOut.toByteArray();
    }
}
