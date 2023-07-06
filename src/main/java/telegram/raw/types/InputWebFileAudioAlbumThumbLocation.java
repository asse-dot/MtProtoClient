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

public class InputWebFileAudioAlbumThumbLocation extends TlObject {

    public static final int ID = -193992412;

    public boolean small;
	public TlObject document;
	public String title;
	public String performer;

    public InputWebFileAudioAlbumThumbLocation(boolean small, TlObject document, String title, String performer) {
        this.small = small;
		this.document = document;
		this.title = title;
		this.performer = performer;
    }

    public static InputWebFileAudioAlbumThumbLocation read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean small = (flags & (1 << 2)) != 0;
		TlObject document = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		String title = (flags & (1 << 1)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		String performer = (flags & (1 << 1)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		
		return new InputWebFileAudioAlbumThumbLocation(small, document, title, performer);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.small ? (1 << 2) : 0;
		flags |= (this.document != null) ? (1 << 0) : 0;
		flags |= (this.title != null) ? (1 << 1) : 0;
		flags |= (this.performer != null) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		if(this.document != null)
			bOut.write(this.document.write());
		if(this.title != null)
			bOut.write(new StringPrimitive(this.title).write());
		if(this.performer != null)
			bOut.write(new StringPrimitive(this.performer).write());
		
		return bOut.toByteArray();
    }
}
