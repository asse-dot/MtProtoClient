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

public class UpdateBotCommands extends TlObject {

    public static final int ID = 1299263278;

    public TlObject peer;
	public long bot_id;
	public ArrayList<TlObject> commands;

    public UpdateBotCommands(TlObject peer, long bot_id, ArrayList<TlObject> commands) {
        this.peer = peer;
		this.bot_id = bot_id;
		this.commands = commands;
    }

    public static UpdateBotCommands read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		long bot_id = LongPrimitive.read(bytes).getValue();
		ArrayList<TlObject> commands = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new UpdateBotCommands(peer, bot_id, commands);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(new LongPrimitive(this.bot_id).write());
		bOut.write(new VectorPrimitive(this.commands).write());
		
		return bOut.toByteArray();
    }
}
