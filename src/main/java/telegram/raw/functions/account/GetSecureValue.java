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

public class GetSecureValue extends TlObject {

    public static final int ID = 1936088002;

    public ArrayList<TlObject> types;

    public GetSecureValue(ArrayList<TlObject> types) {
        this.types = types;
    }

    public static GetSecureValue read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> types = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new GetSecureValue(types);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.types).write());
		
		return bOut.toByteArray();
    }
}
