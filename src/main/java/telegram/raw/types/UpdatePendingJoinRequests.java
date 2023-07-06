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

public class UpdatePendingJoinRequests extends TlObject {

    public static final int ID = 1885586395;

    public TlObject peer;
	public int requests_pending;
	public ArrayList<TlObject> recent_requesters;

    public UpdatePendingJoinRequests(TlObject peer, int requests_pending, ArrayList<TlObject> recent_requesters) {
        this.peer = peer;
		this.requests_pending = requests_pending;
		this.recent_requesters = recent_requesters;
    }

    public static UpdatePendingJoinRequests read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		int requests_pending = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> recent_requesters = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new UpdatePendingJoinRequests(peer, requests_pending, recent_requesters);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(new IntPrimitive(this.requests_pending).write());
		bOut.write(new VectorPrimitive(this.recent_requesters).write());
		
		return bOut.toByteArray();
    }
}
