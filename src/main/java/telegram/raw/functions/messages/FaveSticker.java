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

public class FaveSticker extends TlObject {

    public static final int ID = -1174420133;

    public TlObject id;
	public TlObject unfave;

    public FaveSticker(TlObject id, TlObject unfave) {
        this.id = id;
		this.unfave = unfave;
    }

    public static FaveSticker read(ByteArrayInputStream bytes) throws IOException {
        TlObject id = TlObject.read(bytes);
		TlObject unfave = TlObject.read(bytes);
		
		return new FaveSticker(id, unfave);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.id.write());
		bOut.write(this.unfave.write());
		
		return bOut.toByteArray();
    }
}
