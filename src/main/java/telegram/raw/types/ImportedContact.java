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

public class ImportedContact extends TlObject {

    public static final int ID = -1052885936;

    public long user_id;
	public long client_id;

    public ImportedContact(long user_id, long client_id) {
        this.user_id = user_id;
		this.client_id = client_id;
    }

    public static ImportedContact read(ByteArrayInputStream bytes) throws IOException {
        long user_id = LongPrimitive.read(bytes).getValue();
		long client_id = LongPrimitive.read(bytes).getValue();
		
		return new ImportedContact(user_id, client_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.user_id).write());
		bOut.write(new LongPrimitive(this.client_id).write());
		
		return bOut.toByteArray();
    }
}
