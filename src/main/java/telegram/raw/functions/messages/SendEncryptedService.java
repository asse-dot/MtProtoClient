//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.messages;

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

public class SendEncryptedService extends TlObject {

    public static final int ID = 852769188;

    public TlObject peer;
	public long random_id;
	public byte[] data;

    public SendEncryptedService(TlObject peer, long random_id, byte[] data) {
        this.peer = peer;
		this.random_id = random_id;
		this.data = data;
    }

    public static SendEncryptedService read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		long random_id = LongPrimitive.read(bytes).getValue();
		byte[] data = BytesPrimitive.read(bytes).getValue();
		
		return new SendEncryptedService(peer, random_id, data);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(new LongPrimitive(this.random_id).write());
		bOut.write(new BytesPrimitive(this.data).write());
		
		return bOut.toByteArray();
    }
}
