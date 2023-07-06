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

public class InputStickerSetItem extends TlObject {

    public static final int ID = 853188252;

    public TlObject document;
	public String emoji;
	public TlObject mask_coords;
	public String keywords;

    public InputStickerSetItem(TlObject document, String emoji, TlObject mask_coords, String keywords) {
        this.document = document;
		this.emoji = emoji;
		this.mask_coords = mask_coords;
		this.keywords = keywords;
    }

    public static InputStickerSetItem read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		TlObject document = TlObject.read(bytes);
		String emoji = StringPrimitive.read(bytes).getValue();
		TlObject mask_coords = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		String keywords = (flags & (1 << 1)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		
		return new InputStickerSetItem(document, emoji, mask_coords, keywords);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.mask_coords != null) ? (1 << 0) : 0;
		flags |= (this.keywords != null) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.document.write());
		bOut.write(new StringPrimitive(this.emoji).write());
		if(this.mask_coords != null)
			bOut.write(this.mask_coords.write());
		if(this.keywords != null)
			bOut.write(new StringPrimitive(this.keywords).write());
		
		return bOut.toByteArray();
    }
}
