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

public class InputStickerSetDice extends TlObject {

    public static final int ID = -427863538;

    public String emoticon;

    public InputStickerSetDice(String emoticon) {
        this.emoticon = emoticon;
    }

    public static InputStickerSetDice read(ByteArrayInputStream bytes) throws IOException {
        String emoticon = StringPrimitive.read(bytes).getValue();
		
		return new InputStickerSetDice(emoticon);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.emoticon).write());
		
		return bOut.toByteArray();
    }
}
