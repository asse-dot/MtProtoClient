//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.account;

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

public class SetAuthorizationTTL extends TlObject {

    public static final int ID = -1081501024;

    public int authorization_ttl_days;

    public SetAuthorizationTTL(int authorization_ttl_days) {
        this.authorization_ttl_days = authorization_ttl_days;
    }

    public static SetAuthorizationTTL read(ByteArrayInputStream bytes) throws IOException {
        int authorization_ttl_days = IntPrimitive.read(bytes).getValue();
		
		return new SetAuthorizationTTL(authorization_ttl_days);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.authorization_ttl_days).write());
		
		return bOut.toByteArray();
    }
}
