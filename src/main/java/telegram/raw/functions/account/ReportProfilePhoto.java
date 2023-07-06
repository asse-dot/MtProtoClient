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

public class ReportProfilePhoto extends TlObject {

    public static final int ID = -91437323;

    public TlObject peer;
	public TlObject photo_id;
	public TlObject reason;
	public String message;

    public ReportProfilePhoto(TlObject peer, TlObject photo_id, TlObject reason, String message) {
        this.peer = peer;
		this.photo_id = photo_id;
		this.reason = reason;
		this.message = message;
    }

    public static ReportProfilePhoto read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		TlObject photo_id = TlObject.read(bytes);
		TlObject reason = TlObject.read(bytes);
		String message = StringPrimitive.read(bytes).getValue();
		
		return new ReportProfilePhoto(peer, photo_id, reason, message);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(this.photo_id.write());
		bOut.write(this.reason.write());
		bOut.write(new StringPrimitive(this.message).write());
		
		return bOut.toByteArray();
    }
}
