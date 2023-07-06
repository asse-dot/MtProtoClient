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

public class InputMediaUploadedDocument extends TlObject {

    public static final int ID = 1530447553;

    public boolean nosound_video;
	public boolean force_file;
	public boolean spoiler;
	public TlObject file;
	public TlObject thumb;
	public String mime_type;
	public ArrayList<TlObject> attributes;
	public ArrayList<TlObject> stickers;
	public int ttl_seconds;

    public InputMediaUploadedDocument(boolean nosound_video, boolean force_file, boolean spoiler, TlObject file, TlObject thumb, String mime_type, ArrayList<TlObject> attributes, ArrayList<TlObject> stickers, int ttl_seconds) {
        this.nosound_video = nosound_video;
		this.force_file = force_file;
		this.spoiler = spoiler;
		this.file = file;
		this.thumb = thumb;
		this.mime_type = mime_type;
		this.attributes = attributes;
		this.stickers = stickers;
		this.ttl_seconds = ttl_seconds;
    }

    public static InputMediaUploadedDocument read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean nosound_video = (flags & (1 << 3)) != 0;
		boolean force_file = (flags & (1 << 4)) != 0;
		boolean spoiler = (flags & (1 << 5)) != 0;
		TlObject file = TlObject.read(bytes);
		TlObject thumb = (flags & (1 << 2)) != 0 ?  TlObject.read(bytes) : null;
		String mime_type = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> attributes = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> stickers = (flags & (1 << 0)) != 0 ?  ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;
		int ttl_seconds = (flags & (1 << 1)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		
		return new InputMediaUploadedDocument(nosound_video, force_file, spoiler, file, thumb, mime_type, attributes, stickers, ttl_seconds);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.nosound_video ? (1 << 3) : 0;
		flags |= this.force_file ? (1 << 4) : 0;
		flags |= this.spoiler ? (1 << 5) : 0;
		flags |= (this.thumb != null) ? (1 << 2) : 0;
		flags |= (this.stickers != null) ? (1 << 0) : 0;
		flags |= (this.ttl_seconds != 0) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.file.write());
		if(this.thumb != null)
			bOut.write(this.thumb.write());
		bOut.write(new StringPrimitive(this.mime_type).write());
		bOut.write(new VectorPrimitive(this.attributes).write());
		if(this.stickers != null)
			bOut.write(new VectorPrimitive(this.stickers).write());
		if(this.ttl_seconds != 0)
			bOut.write(new IntPrimitive(this.ttl_seconds).write());
		
		return bOut.toByteArray();
    }
}
