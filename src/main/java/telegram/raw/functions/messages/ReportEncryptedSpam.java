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

public class ReportEncryptedSpam extends TlObject {

    public static final int ID = 1259113487;

    public TlObject peer;

    public ReportEncryptedSpam(TlObject peer) {
        this.peer = peer;
    }

    public static ReportEncryptedSpam read(ByteArrayInputStream bytes) throws IOException {
        TlObject peer = TlObject.read(bytes);
		
		return new ReportEncryptedSpam(peer);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.peer.write());
		
		return bOut.toByteArray();
    }
}
