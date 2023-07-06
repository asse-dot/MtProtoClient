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

public class SetBotPrecheckoutResults extends TlObject {

    public static final int ID = 163765653;

    public boolean success;
	public long query_id;
	public String error;

    public SetBotPrecheckoutResults(boolean success, long query_id, String error) {
        this.success = success;
		this.query_id = query_id;
		this.error = error;
    }

    public static SetBotPrecheckoutResults read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean success = (flags & (1 << 1)) != 0;
		long query_id = LongPrimitive.read(bytes).getValue();
		String error = (flags & (1 << 0)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		
		return new SetBotPrecheckoutResults(success, query_id, error);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.success ? (1 << 1) : 0;
		flags |= (this.error != null) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.query_id).write());
		if(this.error != null)
			bOut.write(new StringPrimitive(this.error).write());
		
		return bOut.toByteArray();
    }
}
