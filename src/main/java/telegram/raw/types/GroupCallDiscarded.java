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

public class GroupCallDiscarded extends TlObject {

    public static final int ID = 2004925620;

    public long id;
	public long access_hash;
	public int duration;

    public GroupCallDiscarded(long id, long access_hash, int duration) {
        this.id = id;
		this.access_hash = access_hash;
		this.duration = duration;
    }

    public static GroupCallDiscarded read(ByteArrayInputStream bytes) throws IOException {
        long id = LongPrimitive.read(bytes).getValue();
		long access_hash = LongPrimitive.read(bytes).getValue();
		int duration = IntPrimitive.read(bytes).getValue();
		
		return new GroupCallDiscarded(id, access_hash, duration);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.id).write());
		bOut.write(new LongPrimitive(this.access_hash).write());
		bOut.write(new IntPrimitive(this.duration).write());
		
		return bOut.toByteArray();
    }
}
