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

public class SendMessageHistoryImportAction extends TlObject {

    public static final int ID = -606432698;

    public int progress;

    public SendMessageHistoryImportAction(int progress) {
        this.progress = progress;
    }

    public static SendMessageHistoryImportAction read(ByteArrayInputStream bytes) throws IOException {
        int progress = IntPrimitive.read(bytes).getValue();
		
		return new SendMessageHistoryImportAction(progress);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.progress).write());
		
		return bOut.toByteArray();
    }
}
