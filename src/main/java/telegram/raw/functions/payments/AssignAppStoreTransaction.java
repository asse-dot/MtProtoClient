//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.payments;

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

public class AssignAppStoreTransaction extends TlObject {

    public static final int ID = -2131921795;

    public byte[] receipt;
	public TlObject purpose;

    public AssignAppStoreTransaction(byte[] receipt, TlObject purpose) {
        this.receipt = receipt;
		this.purpose = purpose;
    }

    public static AssignAppStoreTransaction read(ByteArrayInputStream bytes) throws IOException {
        byte[] receipt = BytesPrimitive.read(bytes).getValue();
		TlObject purpose = TlObject.read(bytes);
		
		return new AssignAppStoreTransaction(receipt, purpose);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new BytesPrimitive(this.receipt).write());
		bOut.write(this.purpose.write());
		
		return bOut.toByteArray();
    }
}
