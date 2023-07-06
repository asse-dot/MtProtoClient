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

public class InputWebFileLocation extends TlObject {

    public static final int ID = -1036396922;

    public String url;
	public long access_hash;

    public InputWebFileLocation(String url, long access_hash) {
        this.url = url;
		this.access_hash = access_hash;
    }

    public static InputWebFileLocation read(ByteArrayInputStream bytes) throws IOException {
        String url = StringPrimitive.read(bytes).getValue();
		long access_hash = LongPrimitive.read(bytes).getValue();
		
		return new InputWebFileLocation(url, access_hash);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.url).write());
		bOut.write(new LongPrimitive(this.access_hash).write());
		
		return bOut.toByteArray();
    }
}
