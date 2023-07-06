//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.upload;

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

public class GetFile extends TlObject {

    public static final int ID = -1101843010;

    public boolean precise;
	public boolean cdn_supported;
	public TlObject location;
	public long offset;
	public int limit;

    public GetFile(boolean precise, boolean cdn_supported, TlObject location, long offset, int limit) {
        this.precise = precise;
		this.cdn_supported = cdn_supported;
		this.location = location;
		this.offset = offset;
		this.limit = limit;
    }

    public static GetFile read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean precise = (flags & (1 << 0)) != 0;
		boolean cdn_supported = (flags & (1 << 1)) != 0;
		TlObject location = TlObject.read(bytes);
		long offset = LongPrimitive.read(bytes).getValue();
		int limit = IntPrimitive.read(bytes).getValue();
		
		return new GetFile(precise, cdn_supported, location, offset, limit);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.precise ? (1 << 0) : 0;
		flags |= this.cdn_supported ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.location.write());
		bOut.write(new LongPrimitive(this.offset).write());
		bOut.write(new IntPrimitive(this.limit).write());
		
		return bOut.toByteArray();
    }
}
