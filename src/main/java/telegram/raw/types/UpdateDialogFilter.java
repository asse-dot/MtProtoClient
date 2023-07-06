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

public class UpdateDialogFilter extends TlObject {

    public static final int ID = 654302845;

    public int id;
	public TlObject filter;

    public UpdateDialogFilter(int id, TlObject filter) {
        this.id = id;
		this.filter = filter;
    }

    public static UpdateDialogFilter read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		int id = IntPrimitive.read(bytes).getValue();
		TlObject filter = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		
		return new UpdateDialogFilter(id, filter);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.filter != null) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new IntPrimitive(this.id).write());
		if(this.filter != null)
			bOut.write(this.filter.write());
		
		return bOut.toByteArray();
    }
}
