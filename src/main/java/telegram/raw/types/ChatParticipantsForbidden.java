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

public class ChatParticipantsForbidden extends TlObject {

    public static final int ID = -2023500831;

    public long chat_id;
	public TlObject self_participant;

    public ChatParticipantsForbidden(long chat_id, TlObject self_participant) {
        this.chat_id = chat_id;
		this.self_participant = self_participant;
    }

    public static ChatParticipantsForbidden read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		long chat_id = LongPrimitive.read(bytes).getValue();
		TlObject self_participant = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		
		return new ChatParticipantsForbidden(chat_id, self_participant);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.self_participant != null) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.chat_id).write());
		if(this.self_participant != null)
			bOut.write(this.self_participant.write());
		
		return bOut.toByteArray();
    }
}
