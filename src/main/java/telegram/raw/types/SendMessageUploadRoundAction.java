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

public class SendMessageUploadRoundAction extends TlObject {

    public static final int ID = 608050278;

    public int progress;

    public SendMessageUploadRoundAction(int progress) {
        this.progress = progress;
    }

    public static SendMessageUploadRoundAction read(ByteArrayInputStream bytes) throws IOException {
        int progress = IntPrimitive.read(bytes).getValue();
		
		return new SendMessageUploadRoundAction(progress);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.progress).write());
		
		return bOut.toByteArray();
    }
}
