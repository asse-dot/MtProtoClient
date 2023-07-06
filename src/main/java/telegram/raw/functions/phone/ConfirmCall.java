//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.phone;

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

public class ConfirmCall extends TlObject {

    public static final int ID = 788404002;

    public TlObject peer;
	public byte[] g_a;
	public long key_fingerprint;
	public TlObject protocol;

    public ConfirmCall(TlObject peer, byte[] g_a, long key_fingerprint, TlObject protocol) {
        this.peer = peer;
		this.g_a = g_a;
		this.key_fingerprint = key_fingerprint;
		this.protocol = protocol;
    }

    public static ConfirmCall read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		byte[] g_a = BytesPrimitive.read(bytes).getValue();
		long key_fingerprint = LongPrimitive.read(bytes).getValue();
		TlObject protocol = TlObject.read(bytes);
		
		return new ConfirmCall(peer, g_a, key_fingerprint, protocol);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(new BytesPrimitive(this.g_a).write());
		bOut.write(new LongPrimitive(this.key_fingerprint).write());
		bOut.write(this.protocol.write());
		
		return bOut.toByteArray();
    }
}
