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

public class UpdateNewMessage extends TlObject {

    public static final int ID = 522914557;

    public TlObject message;
	public int pts;
	public int pts_count;

    public UpdateNewMessage(TlObject message, int pts, int pts_count) {
        this.message = message;
		this.pts = pts;
		this.pts_count = pts_count;
    }

    public static UpdateNewMessage read(ByteArrayInputStream bytes) throws IOException {
        TlObject message = TlObject.read(bytes);
		int pts = IntPrimitive.read(bytes).getValue();
		int pts_count = IntPrimitive.read(bytes).getValue();
		
		return new UpdateNewMessage(message, pts, pts_count);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.message.write());
		bOut.write(new IntPrimitive(this.pts).write());
		bOut.write(new IntPrimitive(this.pts_count).write());
		
		return bOut.toByteArray();
    }
}
