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

public class ChannelAdminLogEventActionParticipantToggleBan extends TlObject {

    public static final int ID = -422036098;

    public TlObject prev_participant;
	public TlObject new_participant;

    public ChannelAdminLogEventActionParticipantToggleBan(TlObject prev_participant, TlObject new_participant) {
        this.prev_participant = prev_participant;
		this.new_participant = new_participant;
    }

    public static ChannelAdminLogEventActionParticipantToggleBan read(ByteArrayInputStream bytes) throws IOException {
        TlObject prev_participant = TlObject.read(bytes);
		TlObject new_participant = TlObject.read(bytes);
		
		return new ChannelAdminLogEventActionParticipantToggleBan(prev_participant, new_participant);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.prev_participant.write());
		bOut.write(this.new_participant.write());
		
		return bOut.toByteArray();
    }
}
