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

public class PhoneCallWaiting extends TlObject {

    public static final int ID = -987599081;

    public boolean video;
	public long id;
	public long access_hash;
	public int date;
	public long admin_id;
	public long participant_id;
	public TlObject protocol;
	public int receive_date;

    public PhoneCallWaiting(boolean video, long id, long access_hash, int date, long admin_id, long participant_id, TlObject protocol, int receive_date) {
        this.video = video;
		this.id = id;
		this.access_hash = access_hash;
		this.date = date;
		this.admin_id = admin_id;
		this.participant_id = participant_id;
		this.protocol = protocol;
		this.receive_date = receive_date;
    }

    public static PhoneCallWaiting read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean video = (flags & (1 << 6)) != 0;
		long id = LongPrimitive.read(bytes).getValue();
		long access_hash = LongPrimitive.read(bytes).getValue();
		int date = IntPrimitive.read(bytes).getValue();
		long admin_id = LongPrimitive.read(bytes).getValue();
		long participant_id = LongPrimitive.read(bytes).getValue();
		TlObject protocol = TlObject.read(bytes);
		int receive_date = (flags & (1 << 0)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		
		return new PhoneCallWaiting(video, id, access_hash, date, admin_id, participant_id, protocol, receive_date);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.video ? (1 << 6) : 0;
		flags |= (this.receive_date != 0) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.id).write());
		bOut.write(new LongPrimitive(this.access_hash).write());
		bOut.write(new IntPrimitive(this.date).write());
		bOut.write(new LongPrimitive(this.admin_id).write());
		bOut.write(new LongPrimitive(this.participant_id).write());
		bOut.write(this.protocol.write());
		if(this.receive_date != 0)
			bOut.write(new IntPrimitive(this.receive_date).write());
		
		return bOut.toByteArray();
    }
}
