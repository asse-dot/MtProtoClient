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

public class Theme extends TlObject {

    public static final int ID = -1609668650;

    public boolean creator;
	public boolean defaultv;
	public boolean for_chat;
	public long id;
	public long access_hash;
	public String slug;
	public String title;
	public TlObject document;
	public ArrayList<TlObject> settings;
	public String emoticon;
	public int installs_count;

    public Theme(boolean creator, boolean defaultv, boolean for_chat, long id, long access_hash, String slug, String title, TlObject document, ArrayList<TlObject> settings, String emoticon, int installs_count) {
        this.creator = creator;
		this.defaultv = defaultv;
		this.for_chat = for_chat;
		this.id = id;
		this.access_hash = access_hash;
		this.slug = slug;
		this.title = title;
		this.document = document;
		this.settings = settings;
		this.emoticon = emoticon;
		this.installs_count = installs_count;
    }

    public static Theme read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean creator = (flags & (1 << 0)) != 0;
		boolean defaultv = (flags & (1 << 1)) != 0;
		boolean for_chat = (flags & (1 << 5)) != 0;
		long id = LongPrimitive.read(bytes).getValue();
		long access_hash = LongPrimitive.read(bytes).getValue();
		String slug = StringPrimitive.read(bytes).getValue();
		String title = StringPrimitive.read(bytes).getValue();
		TlObject document = (flags & (1 << 2)) != 0 ?  TlObject.read(bytes) : null;
		ArrayList<TlObject> settings = (flags & (1 << 3)) != 0 ?  ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;
		String emoticon = (flags & (1 << 6)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		int installs_count = (flags & (1 << 4)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		
		return new Theme(creator, defaultv, for_chat, id, access_hash, slug, title, document, settings, emoticon, installs_count);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.creator ? (1 << 0) : 0;
		flags |= this.defaultv ? (1 << 1) : 0;
		flags |= this.for_chat ? (1 << 5) : 0;
		flags |= (this.document != null) ? (1 << 2) : 0;
		flags |= (this.settings != null) ? (1 << 3) : 0;
		flags |= (this.emoticon != null) ? (1 << 6) : 0;
		flags |= (this.installs_count != 0) ? (1 << 4) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.id).write());
		bOut.write(new LongPrimitive(this.access_hash).write());
		bOut.write(new StringPrimitive(this.slug).write());
		bOut.write(new StringPrimitive(this.title).write());
		if(this.document != null)
			bOut.write(this.document.write());
		if(this.settings != null)
			bOut.write(new VectorPrimitive(this.settings).write());
		if(this.emoticon != null)
			bOut.write(new StringPrimitive(this.emoticon).write());
		if(this.installs_count != 0)
			bOut.write(new IntPrimitive(this.installs_count).write());
		
		return bOut.toByteArray();
    }
}
