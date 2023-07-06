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

public class EditChatDefaultBannedRights extends TlObject {

    public static final int ID = -1517917375;

    public TlObject peer;
	public TlObject banned_rights;

    public EditChatDefaultBannedRights(TlObject peer, TlObject banned_rights) {
        this.peer = peer;
		this.banned_rights = banned_rights;
    }

    public static EditChatDefaultBannedRights read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		TlObject banned_rights = TlObject.read(bytes);
		
		return new EditChatDefaultBannedRights(peer, banned_rights);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(this.banned_rights.write());
		
		return bOut.toByteArray();
    }
}
