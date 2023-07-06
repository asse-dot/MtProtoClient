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

public class EmailVerificationCode extends TlObject {

    public static final int ID = -1842457175;

    public String code;

    public EmailVerificationCode(String code) {
        this.code = code;
    }

    public static EmailVerificationCode read(ByteArrayInputStream bytes) throws IOException {
        String code = StringPrimitive.read(bytes).getValue();
		
		return new EmailVerificationCode(code);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.code).write());
		
		return bOut.toByteArray();
    }
}
