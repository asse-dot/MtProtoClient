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

public class UpdateGroupCallParticipants extends TlObject {

    public static final int ID = -219423922;

    public TlObject call;
	public ArrayList<TlObject> participants;
	public int version;

    public UpdateGroupCallParticipants(TlObject call, ArrayList<TlObject> participants, int version) {
        this.call = call;
		this.participants = participants;
		this.version = version;
    }

    public static UpdateGroupCallParticipants read(ByteArrayInputStream bytes) throws IOException {
        TlObject call = TlObject.read(bytes);
		ArrayList<TlObject> participants = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		int version = IntPrimitive.read(bytes).getValue();
		
		return new UpdateGroupCallParticipants(call, participants, version);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.call.write());
		bOut.write(new VectorPrimitive(this.participants).write());
		bOut.write(new IntPrimitive(this.version).write());
		
		return bOut.toByteArray();
    }
}
