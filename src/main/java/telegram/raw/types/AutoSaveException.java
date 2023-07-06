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

public class AutoSaveException extends TlObject {

    public static final int ID = -2124403385;

    public TlObject peer;
	public TlObject settings;

    public AutoSaveException(TlObject peer, TlObject settings) {
        this.peer = peer;
		this.settings = settings;
    }

    public static AutoSaveException read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		TlObject settings = TlObject.read(bytes);
		
		return new AutoSaveException(peer, settings);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		bOut.write(this.settings.write());
		
		return bOut.toByteArray();
    }
}
