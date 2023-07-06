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

public class BotCommandScopePeer extends TlObject {

    public static final int ID = -610432643;

    public TlObject peer;

    public BotCommandScopePeer(TlObject peer) {
        this.peer = peer;
    }

    public static BotCommandScopePeer read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		
		return new BotCommandScopePeer(peer);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		
		return bOut.toByteArray();
    }
}
