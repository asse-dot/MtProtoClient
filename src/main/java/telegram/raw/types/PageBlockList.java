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

public class PageBlockList extends TlObject {

    public static final int ID = -454524911;

    public ArrayList<TlObject> items;

    public PageBlockList(ArrayList<TlObject> items) {
        this.items = items;
    }

    public static PageBlockList read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> items = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new PageBlockList(items);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.items).write());
		
		return bOut.toByteArray();
    }
}
