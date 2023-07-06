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

public class ChannelParticipantCreator extends TlObject {

    public static final int ID = 803602899;

    public long user_id;
	public TlObject admin_rights;
	public String rank;

    public ChannelParticipantCreator(long user_id, TlObject admin_rights, String rank) {
        this.user_id = user_id;
		this.admin_rights = admin_rights;
		this.rank = rank;
    }

    public static ChannelParticipantCreator read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		long user_id = LongPrimitive.read(bytes).getValue();
		TlObject admin_rights = TlObject.read(bytes);
		String rank = (flags & (1 << 0)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		
		return new ChannelParticipantCreator(user_id, admin_rights, rank);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.rank != null) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.user_id).write());
		bOut.write(this.admin_rights.write());
		if(this.rank != null)
			bOut.write(new StringPrimitive(this.rank).write());
		
		return bOut.toByteArray();
    }
}
