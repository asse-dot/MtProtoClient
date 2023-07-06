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

public class GetFullUser extends TlObject {

    public static final int ID = -1240508136;

    public TlObject id;

    public GetFullUser(TlObject id) {
        this.id = id;
    }

    public static GetFullUser read(ByteArrayInputStream bytes) throws IOException {
        TlObject id = TlObject.read(bytes);
		
		return new GetFullUser(id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.id.write());
		
		return bOut.toByteArray();
    }
}
