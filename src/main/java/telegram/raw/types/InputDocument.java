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

public class InputDocument extends TlObject {

    public static final int ID = 448771445;

    public long id;
	public long access_hash;
	public byte[] file_reference;

    public InputDocument(long id, long access_hash, byte[] file_reference) {
        this.id = id;
		this.access_hash = access_hash;
		this.file_reference = file_reference;
    }

    public static InputDocument read(ByteArrayInputStream bytes) throws IOException {
        long id = LongPrimitive.read(bytes).getValue();
		long access_hash = LongPrimitive.read(bytes).getValue();
		byte[] file_reference = BytesPrimitive.read(bytes).getValue();
		
		return new InputDocument(id, access_hash, file_reference);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.id).write());
		bOut.write(new LongPrimitive(this.access_hash).write());
		bOut.write(new BytesPrimitive(this.file_reference).write());
		
		return bOut.toByteArray();
    }
}
