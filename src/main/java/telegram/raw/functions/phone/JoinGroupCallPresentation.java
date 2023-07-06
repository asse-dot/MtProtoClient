//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.phone;

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

public class JoinGroupCallPresentation extends TlObject {

    public static final int ID = -873829436;

    public TlObject call;
	public TlObject params;

    public JoinGroupCallPresentation(TlObject call, TlObject params) {
        this.call = call;
		this.params = params;
    }

    public static JoinGroupCallPresentation read(ByteArrayInputStream bytes) throws IOException {
        TlObject call = TlObject.read(bytes);
		TlObject params = TlObject.read(bytes);
		
		return new JoinGroupCallPresentation(call, params);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.call.write());
		bOut.write(this.params.write());
		
		return bOut.toByteArray();
    }
}
