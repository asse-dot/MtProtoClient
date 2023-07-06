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

public class ChannelAdminLogEventActionEditMessage extends TlObject {

    public static final int ID = 1889215493;

    public TlObject prev_message;
	public TlObject new_message;

    public ChannelAdminLogEventActionEditMessage(TlObject prev_message, TlObject new_message) {
        this.prev_message = prev_message;
		this.new_message = new_message;
    }

    public static ChannelAdminLogEventActionEditMessage read(ByteArrayInputStream bytes) throws IOException {
        TlObject prev_message = TlObject.read(bytes);
		TlObject new_message = TlObject.read(bytes);
		
		return new ChannelAdminLogEventActionEditMessage(prev_message, new_message);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.prev_message.write());
		bOut.write(this.new_message.write());
		
		return bOut.toByteArray();
    }
}
