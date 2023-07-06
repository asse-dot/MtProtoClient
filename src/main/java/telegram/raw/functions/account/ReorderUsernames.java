//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.account;

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

public class ReorderUsernames extends TlObject {

    public static final int ID = -279966037;

    public ArrayList<TlObject> order;

    public ReorderUsernames(ArrayList<TlObject> order) {
        this.order = order;
    }

    public static ReorderUsernames read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> order = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new ReorderUsernames(order);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.order).write());
		
		return bOut.toByteArray();
    }
}
