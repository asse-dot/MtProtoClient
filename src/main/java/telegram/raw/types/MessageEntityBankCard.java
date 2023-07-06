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

public class MessageEntityBankCard extends TlObject {

    public static final int ID = 1981704948;

    public int offset;
	public int length;

    public MessageEntityBankCard(int offset, int length) {
        this.offset = offset;
		this.length = length;
    }

    public static MessageEntityBankCard read(ByteArrayInputStream bytes) throws IOException {
        int offset = IntPrimitive.read(bytes).getValue();
		int length = IntPrimitive.read(bytes).getValue();
		
		return new MessageEntityBankCard(offset, length);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new IntPrimitive(this.offset).write());
		bOut.write(new IntPrimitive(this.length).write());
		
		return bOut.toByteArray();
    }
}
