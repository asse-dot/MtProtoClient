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

public class KeyboardButtonRow extends TlObject {

    public static final int ID = 2002815875;

    public ArrayList<TlObject> buttons;

    public KeyboardButtonRow(ArrayList<TlObject> buttons) {
        this.buttons = buttons;
    }

    public static KeyboardButtonRow read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> buttons = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new KeyboardButtonRow(buttons);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new VectorPrimitive(this.buttons).write());
		
		return bOut.toByteArray();
    }
}
