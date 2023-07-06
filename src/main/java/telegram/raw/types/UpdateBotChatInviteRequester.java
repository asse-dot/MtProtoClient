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

public class UpdateBotChatInviteRequester extends TlObject {

    public static final int ID = 299870598;

    public TlObject peer;
	public int date;
	public long user_id;
	public String about;
	public TlObject invite;
	public int qts;

    public UpdateBotChatInviteRequester(TlObject peer, int date, long user_id, String about, TlObject invite, int qts) {
        this.peer = peer;
		this.date = date;
		this.user_id = user_id;
		this.about = about;
		this.invite = invite;
		this.qts = qts;
    }

    public static UpdateBotChatInviteRequester read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		int date = IntPrimitive.read(bytes).getValue();
		long user_id = LongPrimitive.read(bytes).getValue();
		String about = StringPrimitive.read(bytes).getValue();
		TlObject invite = TlObject.read(bytes);
		int qts = IntPrimitive.read(bytes).getValue();
		
		return new UpdateBotChatInviteRequester(peer, date, user_id, about, invite, qts);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(new IntPrimitive(this.date).write());
		bOut.write(new LongPrimitive(this.user_id).write());
		bOut.write(new StringPrimitive(this.about).write());
		bOut.write(this.invite.write());
		bOut.write(new IntPrimitive(this.qts).write());
		
		return bOut.toByteArray();
    }
}
