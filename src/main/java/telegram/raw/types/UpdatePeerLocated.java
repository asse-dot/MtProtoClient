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

public class UpdatePeerLocated extends TlObject {

    public static final int ID = -1263546448;

    public ArrayList<TlObject> peers;

    public UpdatePeerLocated(ArrayList<TlObject> peers) {
        this.peers = peers;
    }

    public static UpdatePeerLocated read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> peers = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new UpdatePeerLocated(peers);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.peers).write());
		
		return bOut.toByteArray();
    }
}
