//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.phone;

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

public class LeaveGroupCall extends TlObject {

    public static final int ID = 1342404601;

    public TlObject call;
	public int source;

    public LeaveGroupCall(TlObject call, int source) {
        this.call = call;
		this.source = source;
    }

    public static LeaveGroupCall read(ByteArrayInputStream bytes) throws IOException {
        TlObject call = TlObject.read(bytes);
		int source = IntPrimitive.read(bytes).getValue();
		
		return new LeaveGroupCall(call, source);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.call.write());
		bOut.write(new IntPrimitive(this.source).write());
		
		return bOut.toByteArray();
    }
}
