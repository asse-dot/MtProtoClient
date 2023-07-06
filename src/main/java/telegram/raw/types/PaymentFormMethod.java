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

public class PaymentFormMethod extends TlObject {

    public static final int ID = -1996951013;

    public String url;
	public String title;

    public PaymentFormMethod(String url, String title) {
        this.url = url;
		this.title = title;
    }

    public static PaymentFormMethod read(ByteArrayInputStream bytes) throws IOException {
        String url = StringPrimitive.read(bytes).getValue();
		String title = StringPrimitive.read(bytes).getValue();
		
		return new PaymentFormMethod(url, title);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.url).write());
		bOut.write(new StringPrimitive(this.title).write());
		
		return bOut.toByteArray();
    }
}
