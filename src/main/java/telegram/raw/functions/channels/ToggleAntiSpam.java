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

public class ToggleAntiSpam extends TlObject {

    public static final int ID = 1760814315;

    public TlObject channel;
	public TlObject enabled;

    public ToggleAntiSpam(TlObject channel, TlObject enabled) {
        this.channel = channel;
		this.enabled = enabled;
    }

    public static ToggleAntiSpam read(ByteArrayInputStream bytes) throws IOException {
        TlObject channel = TlObject.read(bytes);
		TlObject enabled = TlObject.read(bytes);
		
		return new ToggleAntiSpam(channel, enabled);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.channel.write());
		bOut.write(this.enabled.write());
		
		return bOut.toByteArray();
    }
}
