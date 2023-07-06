//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.messages;

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

public class AvailableReactions extends TlObject {

    public static final int ID = 1989032621;

    public int hash;
	public ArrayList<TlObject> reactions;

    public AvailableReactions(int hash, ArrayList<TlObject> reactions) {
        this.hash = hash;
		this.reactions = reactions;
    }

    public static AvailableReactions read(ByteArrayInputStream bytes) throws IOException {
        int hash = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> reactions = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new AvailableReactions(hash, reactions);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.hash).write());
		bOut.write(new VectorPrimitive(this.reactions).write());
		
		return bOut.toByteArray();
    }
}
