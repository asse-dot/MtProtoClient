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

public class RecentMeUrlStickerSet extends TlObject {

    public static final int ID = -1140172836;

    public String url;
	public TlObject set;

    public RecentMeUrlStickerSet(String url, TlObject set) {
        this.url = url;
		this.set = set;
    }

    public static RecentMeUrlStickerSet read(ByteArrayInputStream bytes) throws IOException {
        String url = StringPrimitive.read(bytes).getValue();
		TlObject set = TlObject.read(bytes);
		
		return new RecentMeUrlStickerSet(url, set);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.url).write());
		bOut.write(this.set.write());
		
		return bOut.toByteArray();
    }
}
