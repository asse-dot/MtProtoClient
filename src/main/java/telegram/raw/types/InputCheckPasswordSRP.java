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

public class InputCheckPasswordSRP extends TlObject {

    public static final int ID = -763367294;

    public long srp_id;
	public byte[] A;
	public byte[] M1;

    public InputCheckPasswordSRP(long srp_id, byte[] A, byte[] M1) {
        this.srp_id = srp_id;
		this.A = A;
		this.M1 = M1;
    }

    public static InputCheckPasswordSRP read(ByteArrayInputStream bytes) throws IOException {
        long srp_id = LongPrimitive.read(bytes).getValue();
		byte[] A = BytesPrimitive.read(bytes).getValue();
		byte[] M1 = BytesPrimitive.read(bytes).getValue();
		
		return new InputCheckPasswordSRP(srp_id, A, M1);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.srp_id).write());
		bOut.write(new BytesPrimitive(this.A).write());
		bOut.write(new BytesPrimitive(this.M1).write());
		
		return bOut.toByteArray();
    }
}
