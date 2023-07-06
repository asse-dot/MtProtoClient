//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.chatlists;

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

public class LeaveChatlist extends TlObject {

    public static final int ID = 1962598714;

    public TlObject chatlist;
	public ArrayList<TlObject> peers;

    public LeaveChatlist(TlObject chatlist, ArrayList<TlObject> peers) {
        this.chatlist = chatlist;
		this.peers = peers;
    }

    public static LeaveChatlist read(ByteArrayInputStream bytes) throws IOException {
        TlObject chatlist = TlObject.read(bytes);
		ArrayList<TlObject> peers = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new LeaveChatlist(chatlist, peers);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.chatlist.write());
		bOut.write(new VectorPrimitive(this.peers).write());
		
		return bOut.toByteArray();
    }
}
