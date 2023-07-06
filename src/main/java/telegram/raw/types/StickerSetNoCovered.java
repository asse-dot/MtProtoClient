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

public class StickerSetNoCovered extends TlObject {

    public static final int ID = 2008112412;

    public TlObject set;

    public StickerSetNoCovered(TlObject set) {
        this.set = set;
    }

    public static StickerSetNoCovered read(ByteArrayInputStream bytes) throws IOException {
        TlObject set = TlObject.read(bytes);
		
		return new StickerSetNoCovered(set);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.set.write());
		
		return bOut.toByteArray();
    }
}
