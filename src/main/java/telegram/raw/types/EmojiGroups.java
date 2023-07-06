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

public class EmojiGroups extends TlObject {

    public static final int ID = -2011186869;

    public int hash;
	public ArrayList<TlObject> groups;

    public EmojiGroups(int hash, ArrayList<TlObject> groups) {
        this.hash = hash;
		this.groups = groups;
    }

    public static EmojiGroups read(ByteArrayInputStream bytes) throws IOException {
        int hash = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> groups = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new EmojiGroups(hash, groups);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.hash).write());
		bOut.write(new VectorPrimitive(this.groups).write());
		
		return bOut.toByteArray();
    }
}
