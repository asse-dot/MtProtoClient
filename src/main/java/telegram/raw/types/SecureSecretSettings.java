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

public class SecureSecretSettings extends TlObject {

    public static final int ID = 354925740;

    public TlObject secure_algo;
	public byte[] secure_secret;
	public long secure_secret_id;

    public SecureSecretSettings(TlObject secure_algo, byte[] secure_secret, long secure_secret_id) {
        this.secure_algo = secure_algo;
		this.secure_secret = secure_secret;
		this.secure_secret_id = secure_secret_id;
    }

    public static SecureSecretSettings read(ByteArrayInputStream bytes) throws IOException {
        TlObject secure_algo = TlObject.read(bytes);
		byte[] secure_secret = BytesPrimitive.read(bytes).getValue();
		long secure_secret_id = LongPrimitive.read(bytes).getValue();
		
		return new SecureSecretSettings(secure_algo, secure_secret, secure_secret_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.secure_algo.write());
		bOut.write(new BytesPrimitive(this.secure_secret).write());
		bOut.write(new LongPrimitive(this.secure_secret_id).write());
		
		return bOut.toByteArray();
    }
}
