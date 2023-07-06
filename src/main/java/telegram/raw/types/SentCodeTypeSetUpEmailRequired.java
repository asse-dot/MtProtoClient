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

public class SentCodeTypeSetUpEmailRequired extends TlObject {

    public static final int ID = -1521934870;

    public boolean apple_signin_allowed;
	public boolean google_signin_allowed;

    public SentCodeTypeSetUpEmailRequired(boolean apple_signin_allowed, boolean google_signin_allowed) {
        this.apple_signin_allowed = apple_signin_allowed;
		this.google_signin_allowed = google_signin_allowed;
    }

    public static SentCodeTypeSetUpEmailRequired read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean apple_signin_allowed = (flags & (1 << 0)) != 0;
		boolean google_signin_allowed = (flags & (1 << 1)) != 0;
		
		return new SentCodeTypeSetUpEmailRequired(apple_signin_allowed, google_signin_allowed);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.apple_signin_allowed ? (1 << 0) : 0;
		flags |= this.google_signin_allowed ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		
		return bOut.toByteArray();
    }
}
