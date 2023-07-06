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

public class ExportChatlistInvite extends TlObject {

    public static final int ID = -2072885362;

    public TlObject chatlist;
	public String title;
	public ArrayList<TlObject> peers;

    public ExportChatlistInvite(TlObject chatlist, String title, ArrayList<TlObject> peers) {
        this.chatlist = chatlist;
		this.title = title;
		this.peers = peers;
    }

    public static ExportChatlistInvite read(ByteArrayInputStream bytes) throws IOException {
        TlObject chatlist = TlObject.read(bytes);
		String title = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> peers = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new ExportChatlistInvite(chatlist, title, peers);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.chatlist.write());
		bOut.write(new StringPrimitive(this.title).write());
		bOut.write(new VectorPrimitive(this.peers).write());
		
		return bOut.toByteArray();
    }
}
