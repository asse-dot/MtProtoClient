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

public class KeyboardButtonUrl extends TlObject {

    public static final int ID = 629866245;

    public String text;
	public String url;

    public KeyboardButtonUrl(String text, String url) {
        this.text = text;
		this.url = url;
    }

    public static KeyboardButtonUrl read(ByteArrayInputStream bytes) throws IOException {
        String text = StringPrimitive.read(bytes).getValue();
		String url = StringPrimitive.read(bytes).getValue();
		
		return new KeyboardButtonUrl(text, url);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.text).write());
		bOut.write(new StringPrimitive(this.url).write());
		
		return bOut.toByteArray();
    }
}
