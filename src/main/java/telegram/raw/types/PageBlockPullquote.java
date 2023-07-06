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

public class PageBlockPullquote extends TlObject {

    public static final int ID = 1329878739;

    public TlObject text;
	public TlObject caption;

    public PageBlockPullquote(TlObject text, TlObject caption) {
        this.text = text;
		this.caption = caption;
    }

    public static PageBlockPullquote read(ByteArrayInputStream bytes) throws IOException {
        TlObject text = TlObject.read(bytes);
		TlObject caption = TlObject.read(bytes);
		
		return new PageBlockPullquote(text, caption);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.text.write());
		bOut.write(this.caption.write());
		
		return bOut.toByteArray();
    }
}
