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

public class SearchCustomEmoji extends TlObject {

    public static final int ID = 739360983;

    public String emoticon;
	public long hash;

    public SearchCustomEmoji(String emoticon, long hash) {
        this.emoticon = emoticon;
		this.hash = hash;
    }

    public static SearchCustomEmoji read(ByteArrayInputStream bytes) throws IOException {
        String emoticon = StringPrimitive.read(bytes).getValue();
		long hash = LongPrimitive.read(bytes).getValue();
		
		return new SearchCustomEmoji(emoticon, hash);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.emoticon).write());
		bOut.write(new LongPrimitive(this.hash).write());
		
		return bOut.toByteArray();
    }
}
