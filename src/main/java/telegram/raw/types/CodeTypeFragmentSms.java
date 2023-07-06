//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.auth;

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

public class CodeTypeFragmentSms extends TlObject {

    public static final int ID = 116234636;

    

    public CodeTypeFragmentSms() {
        
    }

    public static CodeTypeFragmentSms read(ByteArrayInputStream bytes) throws IOException {
        
		return new CodeTypeFragmentSms();
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		
		return bOut.toByteArray();
    }
}
