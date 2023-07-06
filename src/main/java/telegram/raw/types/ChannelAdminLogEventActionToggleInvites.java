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

public class ChannelAdminLogEventActionToggleInvites extends TlObject {

    public static final int ID = 460916654;

    public TlObject new_value;

    public ChannelAdminLogEventActionToggleInvites(TlObject new_value) {
        this.new_value = new_value;
    }

    public static ChannelAdminLogEventActionToggleInvites read(ByteArrayInputStream bytes) throws IOException {
        TlObject new_value = TlObject.read(bytes);
		
		return new ChannelAdminLogEventActionToggleInvites(new_value);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.new_value.write());
		
		return bOut.toByteArray();
    }
}
