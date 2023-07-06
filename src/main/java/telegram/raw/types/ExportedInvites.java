//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.chatlists;

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

public class ExportedInvites extends TlObject {

    public static final int ID = 279670215;

    public ArrayList<TlObject> invites;
	public ArrayList<TlObject> chats;
	public ArrayList<TlObject> users;

    public ExportedInvites(ArrayList<TlObject> invites, ArrayList<TlObject> chats, ArrayList<TlObject> users) {
        this.invites = invites;
		this.chats = chats;
		this.users = users;
    }

    public static ExportedInvites read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> invites = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> chats = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new ExportedInvites(invites, chats, users);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.invites).write());
		bOut.write(new VectorPrimitive(this.chats).write());
		bOut.write(new VectorPrimitive(this.users).write());
		
		return bOut.toByteArray();
    }
}
