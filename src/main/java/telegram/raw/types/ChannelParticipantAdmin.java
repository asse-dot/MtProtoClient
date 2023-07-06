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

public class ChannelParticipantAdmin extends TlObject {

    public static final int ID = 885242707;

    public boolean can_edit;
	public boolean self;
	public long user_id;
	public long inviter_id;
	public long promoted_by;
	public int date;
	public TlObject admin_rights;
	public String rank;

    public ChannelParticipantAdmin(boolean can_edit, boolean self, long user_id, long inviter_id, long promoted_by, int date, TlObject admin_rights, String rank) {
        this.can_edit = can_edit;
		this.self = self;
		this.user_id = user_id;
		this.inviter_id = inviter_id;
		this.promoted_by = promoted_by;
		this.date = date;
		this.admin_rights = admin_rights;
		this.rank = rank;
    }

    public static ChannelParticipantAdmin read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean can_edit = (flags & (1 << 0)) != 0;
		boolean self = (flags & (1 << 1)) != 0;
		long user_id = LongPrimitive.read(bytes).getValue();
		long inviter_id = (flags & (1 << 1)) != 0 ?  LongPrimitive.read(bytes).getValue() : 0;
		long promoted_by = LongPrimitive.read(bytes).getValue();
		int date = IntPrimitive.read(bytes).getValue();
		TlObject admin_rights = TlObject.read(bytes);
		String rank = (flags & (1 << 2)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		
		return new ChannelParticipantAdmin(can_edit, self, user_id, inviter_id, promoted_by, date, admin_rights, rank);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.can_edit ? (1 << 0) : 0;
		flags |= this.self ? (1 << 1) : 0;
		flags |= (this.inviter_id != 0) ? (1 << 1) : 0;
		flags |= (this.rank != null) ? (1 << 2) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.user_id).write());
		if(this.inviter_id != 0)
			bOut.write(new LongPrimitive(this.inviter_id).write());
		bOut.write(new LongPrimitive(this.promoted_by).write());
		bOut.write(new IntPrimitive(this.date).write());
		bOut.write(this.admin_rights.write());
		if(this.rank != null)
			bOut.write(new StringPrimitive(this.rank).write());
		
		return bOut.toByteArray();
    }
}
