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

public class UpdateBotInlineSend extends TlObject {

    public static final int ID = 317794823;

    public long user_id;
	public String query;
	public TlObject geo;
	public String id;
	public TlObject msg_id;

    public UpdateBotInlineSend(long user_id, String query, TlObject geo, String id, TlObject msg_id) {
        this.user_id = user_id;
		this.query = query;
		this.geo = geo;
		this.id = id;
		this.msg_id = msg_id;
    }

    public static UpdateBotInlineSend read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		long user_id = LongPrimitive.read(bytes).getValue();
		String query = StringPrimitive.read(bytes).getValue();
		TlObject geo = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		String id = StringPrimitive.read(bytes).getValue();
		TlObject msg_id = (flags & (1 << 1)) != 0 ?  TlObject.read(bytes) : null;
		
		return new UpdateBotInlineSend(user_id, query, geo, id, msg_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.geo != null) ? (1 << 0) : 0;
		flags |= (this.msg_id != null) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.user_id).write());
		bOut.write(new StringPrimitive(this.query).write());
		if(this.geo != null)
			bOut.write(this.geo.write());
		bOut.write(new StringPrimitive(this.id).write());
		if(this.msg_id != null)
			bOut.write(this.msg_id.write());
		
		return bOut.toByteArray();
    }
}
