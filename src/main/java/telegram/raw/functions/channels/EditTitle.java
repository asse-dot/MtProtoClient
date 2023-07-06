//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.channels;

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

public class EditTitle extends TlObject {

    public static final int ID = 1450044624;

    public TlObject channel;
	public String title;

    public EditTitle(TlObject channel, String title) {
        this.channel = channel;
		this.title = title;
    }

    public static EditTitle read(ByteArrayInputStream bytes) throws IOException {
        TlObject channel = TlObject.read(bytes);
		String title = StringPrimitive.read(bytes).getValue();
		
		return new EditTitle(channel, title);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.channel.write());
		bOut.write(new StringPrimitive(this.title).write());
		
		return bOut.toByteArray();
    }
}
