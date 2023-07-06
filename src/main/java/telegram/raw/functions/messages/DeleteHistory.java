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

public class DeleteHistory extends TlObject {

    public static final int ID = -1332768214;

    public boolean just_clear;
	public boolean revoke;
	public TlObject peer;
	public int max_id;
	public int min_date;
	public int max_date;

    public DeleteHistory(boolean just_clear, boolean revoke, TlObject peer, int max_id, int min_date, int max_date) {
        this.just_clear = just_clear;
		this.revoke = revoke;
		this.peer = peer;
		this.max_id = max_id;
		this.min_date = min_date;
		this.max_date = max_date;
    }

    public static DeleteHistory read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean just_clear = (flags & (1 << 0)) != 0;
		boolean revoke = (flags & (1 << 1)) != 0;
		TlObject peer = TlObject.read(bytes);
		int max_id = IntPrimitive.read(bytes).getValue();
		int min_date = (flags & (1 << 2)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		int max_date = (flags & (1 << 3)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		
		return new DeleteHistory(just_clear, revoke, peer, max_id, min_date, max_date);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.just_clear ? (1 << 0) : 0;
		flags |= this.revoke ? (1 << 1) : 0;
		flags |= (this.min_date != 0) ? (1 << 2) : 0;
		flags |= (this.max_date != 0) ? (1 << 3) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.peer.write());
		bOut.write(new IntPrimitive(this.max_id).write());
		if(this.min_date != 0)
			bOut.write(new IntPrimitive(this.min_date).write());
		if(this.max_date != 0)
			bOut.write(new IntPrimitive(this.max_date).write());
		
		return bOut.toByteArray();
    }
}
