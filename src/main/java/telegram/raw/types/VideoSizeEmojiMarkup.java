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

public class VideoSizeEmojiMarkup extends TlObject {

    public static final int ID = -128171716;

    public long emoji_id;
	public ArrayList<TlObject> background_colors;

    public VideoSizeEmojiMarkup(long emoji_id, ArrayList<TlObject> background_colors) {
        this.emoji_id = emoji_id;
		this.background_colors = background_colors;
    }

    public static VideoSizeEmojiMarkup read(ByteArrayInputStream bytes) throws IOException {
        long emoji_id = LongPrimitive.read(bytes).getValue();
		ArrayList<TlObject> background_colors = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new VideoSizeEmojiMarkup(emoji_id, background_colors);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new LongPrimitive(this.emoji_id).write());
		bOut.write(new VectorPrimitive(this.background_colors).write());
		
		return bOut.toByteArray();
    }
}
