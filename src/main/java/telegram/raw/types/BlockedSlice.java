//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.contacts;

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

public class BlockedSlice extends TlObject {

    public static final int ID = -513392236;

    public int count;
	public ArrayList<TlObject> blocked;
	public ArrayList<TlObject> chats;
	public ArrayList<TlObject> users;

    public BlockedSlice(int count, ArrayList<TlObject> blocked, ArrayList<TlObject> chats, ArrayList<TlObject> users) {
        this.count = count;
		this.blocked = blocked;
		this.chats = chats;
		this.users = users;
    }

    public static BlockedSlice read(ByteArrayInputStream bytes) throws IOException {
        int count = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> blocked = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> chats = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new BlockedSlice(count, blocked, chats, users);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.count).write());
		bOut.write(new VectorPrimitive(this.blocked).write());
		bOut.write(new VectorPrimitive(this.chats).write());
		bOut.write(new VectorPrimitive(this.users).write());
		
		return bOut.toByteArray();
    }
}
