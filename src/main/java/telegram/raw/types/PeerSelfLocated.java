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

public class PeerSelfLocated extends TlObject {

    public static final int ID = -118740917;

    public int expires;

    public PeerSelfLocated(int expires) {
        this.expires = expires;
    }

    public static PeerSelfLocated read(ByteArrayInputStream bytes) throws IOException {
        int expires = IntPrimitive.read(bytes).getValue();
		
		return new PeerSelfLocated(expires);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.expires).write());
		
		return bOut.toByteArray();
    }
}
