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

public class UpdateUserTyping extends TlObject {

    public static final int ID = -1071741569;

    public long user_id;
	public TlObject action;

    public UpdateUserTyping(long user_id, TlObject action) {
        this.user_id = user_id;
		this.action = action;
    }

    public static UpdateUserTyping read(ByteArrayInputStream bytes) throws IOException {
        long user_id = LongPrimitive.read(bytes).getValue();
		TlObject action = TlObject.read(bytes);
		
		return new UpdateUserTyping(user_id, action);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.user_id).write());
		bOut.write(this.action.write());
		
		return bOut.toByteArray();
    }
}
