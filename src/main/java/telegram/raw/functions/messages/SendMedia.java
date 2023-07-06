//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.messages;

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

public class SendMedia extends TlObject {

    public static final int ID = 1967638886;

    public boolean silent;
	public boolean background;
	public boolean clear_draft;
	public boolean noforwards;
	public boolean update_stickersets_order;
	public TlObject peer;
	public int reply_to_msg_id;
	public int top_msg_id;
	public TlObject media;
	public String message;
	public long random_id;
	public TlObject reply_markup;
	public ArrayList<TlObject> entities;
	public int schedule_date;
	public TlObject send_as;

    public SendMedia(boolean silent, boolean background, boolean clear_draft, boolean noforwards, boolean update_stickersets_order, TlObject peer, int reply_to_msg_id, int top_msg_id, TlObject media, String message, long random_id, TlObject reply_markup, ArrayList<TlObject> entities, int schedule_date, TlObject send_as) {
        this.silent = silent;
		this.background = background;
		this.clear_draft = clear_draft;
		this.noforwards = noforwards;
		this.update_stickersets_order = update_stickersets_order;
		this.peer = peer;
		this.reply_to_msg_id = reply_to_msg_id;
		this.top_msg_id = top_msg_id;
		this.media = media;
		this.message = message;
		this.random_id = random_id;
		this.reply_markup = reply_markup;
		this.entities = entities;
		this.schedule_date = schedule_date;
		this.send_as = send_as;
    }

    public static SendMedia read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean silent = (flags & (1 << 5)) != 0;
		boolean background = (flags & (1 << 6)) != 0;
		boolean clear_draft = (flags & (1 << 7)) != 0;
		boolean noforwards = (flags & (1 << 14)) != 0;
		boolean update_stickersets_order = (flags & (1 << 15)) != 0;
		TlObject peer = TlObject.read(bytes);
		int reply_to_msg_id = (flags & (1 << 0)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		int top_msg_id = (flags & (1 << 9)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		TlObject media = TlObject.read(bytes);
		String message = StringPrimitive.read(bytes).getValue();
		long random_id = LongPrimitive.read(bytes).getValue();
		TlObject reply_markup = (flags & (1 << 2)) != 0 ?  TlObject.read(bytes) : null;
		ArrayList<TlObject> entities = (flags & (1 << 3)) != 0 ?  ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;
		int schedule_date = (flags & (1 << 10)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		TlObject send_as = (flags & (1 << 13)) != 0 ?  TlObject.read(bytes) : null;
		
		return new SendMedia(silent, background, clear_draft, noforwards, update_stickersets_order, peer, reply_to_msg_id, top_msg_id, media, message, random_id, reply_markup, entities, schedule_date, send_as);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.silent ? (1 << 5) : 0;
		flags |= this.background ? (1 << 6) : 0;
		flags |= this.clear_draft ? (1 << 7) : 0;
		flags |= this.noforwards ? (1 << 14) : 0;
		flags |= this.update_stickersets_order ? (1 << 15) : 0;
		flags |= (this.reply_to_msg_id != 0) ? (1 << 0) : 0;
		flags |= (this.top_msg_id != 0) ? (1 << 9) : 0;
		flags |= (this.reply_markup != null) ? (1 << 2) : 0;
		flags |= (this.entities != null) ? (1 << 3) : 0;
		flags |= (this.schedule_date != 0) ? (1 << 10) : 0;
		flags |= (this.send_as != null) ? (1 << 13) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.peer.write());
		if(this.reply_to_msg_id != 0)
			bOut.write(new IntPrimitive(this.reply_to_msg_id).write());
		if(this.top_msg_id != 0)
			bOut.write(new IntPrimitive(this.top_msg_id).write());
		bOut.write(this.media.write());
		bOut.write(new StringPrimitive(this.message).write());
		bOut.write(new LongPrimitive(this.random_id).write());
		if(this.reply_markup != null)
			bOut.write(this.reply_markup.write());
		if(this.entities != null)
			bOut.write(new VectorPrimitive(this.entities).write());
		if(this.schedule_date != 0)
			bOut.write(new IntPrimitive(this.schedule_date).write());
		if(this.send_as != null)
			bOut.write(this.send_as.write());
		
		return bOut.toByteArray();
    }
}
