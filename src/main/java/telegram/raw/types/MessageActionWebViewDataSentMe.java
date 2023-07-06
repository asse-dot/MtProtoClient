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

public class MessageActionWebViewDataSentMe extends TlObject {

    public static final int ID = 1205698681;

    public String text;
	public String data;

    public MessageActionWebViewDataSentMe(String text, String data) {
        this.text = text;
		this.data = data;
    }

    public static MessageActionWebViewDataSentMe read(ByteArrayInputStream bytes) throws IOException {
        String text = StringPrimitive.read(bytes).getValue();
		String data = StringPrimitive.read(bytes).getValue();
		
		return new MessageActionWebViewDataSentMe(text, data);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.text).write());
		bOut.write(new StringPrimitive(this.data).write());
		
		return bOut.toByteArray();
    }
}
