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

public class MessageActionSetMessagesTTL extends TlObject {

    public static final int ID = 1007897979;

    public int period;
	public long auto_setting_from;

    public MessageActionSetMessagesTTL(int period, long auto_setting_from) {
        this.period = period;
		this.auto_setting_from = auto_setting_from;
    }

    public static MessageActionSetMessagesTTL read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		int period = IntPrimitive.read(bytes).getValue();
		long auto_setting_from = (flags & (1 << 0)) != 0 ?  LongPrimitive.read(bytes).getValue() : 0;
		
		return new MessageActionSetMessagesTTL(period, auto_setting_from);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.auto_setting_from != 0) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new IntPrimitive(this.period).write());
		if(this.auto_setting_from != 0)
			bOut.write(new LongPrimitive(this.auto_setting_from).write());
		
		return bOut.toByteArray();
    }
}
