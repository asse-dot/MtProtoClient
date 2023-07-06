//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.users;

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

public class SetSecureValueErrors extends TlObject {

    public static final int ID = -1865902923;

    public TlObject id;
	public ArrayList<TlObject> errors;

    public SetSecureValueErrors(TlObject id, ArrayList<TlObject> errors) {
        this.id = id;
		this.errors = errors;
    }

    public static SetSecureValueErrors read(ByteArrayInputStream bytes) throws IOException {
        TlObject id = TlObject.read(bytes);
		ArrayList<TlObject> errors = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new SetSecureValueErrors(id, errors);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.id.write());
		bOut.write(new VectorPrimitive(this.errors).write());
		
		return bOut.toByteArray();
    }
}
