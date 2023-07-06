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

public class PageBlockCollage extends TlObject {

    public static final int ID = 1705048653;

    public ArrayList<TlObject> items;
	public TlObject caption;

    public PageBlockCollage(ArrayList<TlObject> items, TlObject caption) {
        this.items = items;
		this.caption = caption;
    }

    public static PageBlockCollage read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> items = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		TlObject caption = TlObject.read(bytes);
		
		return new PageBlockCollage(items, caption);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.items).write());
		bOut.write(this.caption.write());
		
		return bOut.toByteArray();
    }
}
