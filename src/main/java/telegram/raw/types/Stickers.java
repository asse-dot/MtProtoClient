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

public class Stickers extends TlObject {

    public static final int ID = 816245886;

    public long hash;
	public ArrayList<TlObject> stickers;

    public Stickers(long hash, ArrayList<TlObject> stickers) {
        this.hash = hash;
		this.stickers = stickers;
    }

    public static Stickers read(ByteArrayInputStream bytes) throws IOException {
        long hash = LongPrimitive.read(bytes).getValue();
		ArrayList<TlObject> stickers = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new Stickers(hash, stickers);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.hash).write());
		bOut.write(new VectorPrimitive(this.stickers).write());
		
		return bOut.toByteArray();
    }
}
