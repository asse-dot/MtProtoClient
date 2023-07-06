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

public class ValidateRequestedInfo extends TlObject {

    public static final int ID = -1228345045;

    public boolean save;
	public TlObject invoice;
	public TlObject info;

    public ValidateRequestedInfo(boolean save, TlObject invoice, TlObject info) {
        this.save = save;
		this.invoice = invoice;
		this.info = info;
    }

    public static ValidateRequestedInfo read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean save = (flags & (1 << 0)) != 0;
		TlObject invoice = TlObject.read(bytes);
		TlObject info = TlObject.read(bytes);
		
		return new ValidateRequestedInfo(save, invoice, info);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.save ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.invoice.write());
		bOut.write(this.info.write());
		
		return bOut.toByteArray();
    }
}
