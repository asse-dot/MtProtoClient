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

public class PageBlockChannel extends TlObject {

    public static final int ID = -283684427;

    public TlObject channel;

    public PageBlockChannel(TlObject channel) {
        this.channel = channel;
    }

    public static PageBlockChannel read(ByteArrayInputStream bytes) throws IOException {
        TlObject channel = TlObject.read(bytes);
		
		return new PageBlockChannel(channel);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.channel.write());
		
		return bOut.toByteArray();
    }
}
