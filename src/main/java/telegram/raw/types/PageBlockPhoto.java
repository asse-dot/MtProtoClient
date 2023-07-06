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

public class PageBlockPhoto extends TlObject {

    public static final int ID = 391759200;

    public long photo_id;
	public TlObject caption;
	public String url;
	public long webpage_id;

    public PageBlockPhoto(long photo_id, TlObject caption, String url, long webpage_id) {
        this.photo_id = photo_id;
		this.caption = caption;
		this.url = url;
		this.webpage_id = webpage_id;
    }

    public static PageBlockPhoto read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		long photo_id = LongPrimitive.read(bytes).getValue();
		TlObject caption = TlObject.read(bytes);
		String url = (flags & (1 << 0)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		long webpage_id = (flags & (1 << 0)) != 0 ?  LongPrimitive.read(bytes).getValue() : 0;
		
		return new PageBlockPhoto(photo_id, caption, url, webpage_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.url != null) ? (1 << 0) : 0;
		flags |= (this.webpage_id != 0) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.photo_id).write());
		bOut.write(this.caption.write());
		if(this.url != null)
			bOut.write(new StringPrimitive(this.url).write());
		if(this.webpage_id != 0)
			bOut.write(new LongPrimitive(this.webpage_id).write());
		
		return bOut.toByteArray();
    }
}
