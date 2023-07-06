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

public class SetBotCallbackAnswer extends TlObject {

    public static final int ID = -712043766;

    public boolean alert;
	public long query_id;
	public String message;
	public String url;
	public int cache_time;

    public SetBotCallbackAnswer(boolean alert, long query_id, String message, String url, int cache_time) {
        this.alert = alert;
		this.query_id = query_id;
		this.message = message;
		this.url = url;
		this.cache_time = cache_time;
    }

    public static SetBotCallbackAnswer read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean alert = (flags & (1 << 1)) != 0;
		long query_id = LongPrimitive.read(bytes).getValue();
		String message = (flags & (1 << 0)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		String url = (flags & (1 << 2)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		int cache_time = IntPrimitive.read(bytes).getValue();
		
		return new SetBotCallbackAnswer(alert, query_id, message, url, cache_time);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.alert ? (1 << 1) : 0;
		flags |= (this.message != null) ? (1 << 0) : 0;
		flags |= (this.url != null) ? (1 << 2) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.query_id).write());
		if(this.message != null)
			bOut.write(new StringPrimitive(this.message).write());
		if(this.url != null)
			bOut.write(new StringPrimitive(this.url).write());
		bOut.write(new IntPrimitive(this.cache_time).write());
		
		return bOut.toByteArray();
    }
}
