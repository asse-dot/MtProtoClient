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

public class GetAttachMenuBots extends TlObject {

    public static final int ID = 385663691;

    public long hash;

    public GetAttachMenuBots(long hash) {
        this.hash = hash;
    }

    public static GetAttachMenuBots read(ByteArrayInputStream bytes) throws IOException {
        long hash = LongPrimitive.read(bytes).getValue();
		
		return new GetAttachMenuBots(hash);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.hash).write());
		
		return bOut.toByteArray();
    }
}
