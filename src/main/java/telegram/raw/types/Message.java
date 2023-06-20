package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Message extends TlObject {

    public static final int ID = 0x38116ee0;

    public int id;
    public TlObject peer_id;
    public int date;
    public String message;
    public boolean out;
    public boolean mentioned;
    public boolean media_unread;
    public boolean silent;
    public boolean post;
    public boolean from_scheduled;
    public boolean legacy;
    public boolean edit_hide;
    public boolean pinned;
    public boolean noforwards;
    public TlObject from_id;
    public TlObject fwd_from;
    public long via_bot_id;
    public TlObject reply_to;
    public TlObject media;
    public TlObject reply_markup;
    public ArrayList<TlObject> entities;
    public int views;
    public int forwards;
    public TlObject replies;
    public int edit_date;
    public String post_author;
    public long grouped_id;
    public TlObject reactions;
    public ArrayList<TlObject> restriction_reason;
    public int ttl_period;

    public Message(int id, TlObject peer_id, int date, String message, boolean out, boolean mentioned, boolean media_unread, boolean silent, boolean post, boolean from_scheduled, boolean legacy, boolean edit_hide, boolean pinned, boolean noforwards, TlObject from_id, TlObject fwd_from, long via_bot_id, TlObject reply_to, TlObject media, TlObject reply_markup, ArrayList<TlObject> entities, int views, int forwards, TlObject replies, int edit_date, String post_author, long grouped_id, TlObject reactions, ArrayList<TlObject> restriction_reason, int ttl_period) {
        this.id = id;
        this.peer_id = peer_id;
        this.date = date;
        this.message = message;
        this.out = out;
        this.mentioned = mentioned;
        this.media_unread = media_unread;
        this.silent = silent;
        this.post = post;
        this.from_scheduled = from_scheduled;
        this.legacy = legacy;
        this.edit_hide = edit_hide;
        this.pinned = pinned;
        this.noforwards = noforwards;
        this.from_id = from_id;
        this.fwd_from = fwd_from;
        this.via_bot_id = via_bot_id;
        this.reply_to = reply_to;
        this.media = media;
        this.reply_markup = reply_markup;
        this.entities = entities;
        this.views = views;
        this.forwards = forwards;
        this.replies = replies;
        this.edit_date = edit_date;
        this.post_author = post_author;
        this.grouped_id = grouped_id;
        this.reactions = reactions;
        this.restriction_reason = restriction_reason;
        this.ttl_period = ttl_period;
    }

    public static Message read(ByteArrayInputStream bytes) throws IOException {

        int flags = IntPrimitive.read(bytes).getValue();

        boolean out = (flags & (1 << 1)) != 0;
        boolean mentioned = (flags & (1 << 4)) != 0;
        boolean media_unread = (flags & (1 << 5)) != 0;
        boolean silent = (flags & (1 << 13)) != 0;
        boolean post = (flags & (1 << 14)) != 0;
        boolean from_scheduled = (flags & (1 << 18)) != 0;
        boolean legacy = (flags & (1 << 19)) != 0;
        boolean edit_hide = (flags & (1 << 21)) != 0;
        boolean pinned = (flags & (1 << 24)) != 0;
        boolean noforwards = (flags & (1 << 26)) != 0;

        int id = IntPrimitive.read(bytes).getValue();

        TlObject from_id = (flags & (1 << 8)) != 0 ? TlObject.read(bytes) : null;
        TlObject peer_id = TlObject.read(bytes);
        TlObject fwd_from = (flags & (1 << 2)) != 0 ? TlObject.read(bytes) : null;

        long via_bot_id = (flags & (1 << 11)) != 0 ? LongPrimitive.read(bytes).getValue() : 0;
        TlObject reply_to = (flags & (1 << 3)) != 0 ? TlObject.read(bytes) : null;

        int date = IntPrimitive.read(bytes).getValue();
        String message = StringPrimitive.read(bytes).getValue();
        TlObject media = (flags & (1 << 9)) != 0 ? TlObject.read(bytes) : null;
        TlObject reply_markup = (flags & (1 << 6)) != 0 ? TlObject.read(bytes) : null;
        ArrayList<TlObject> entities = (flags & (1 << 7)) != 0 ? ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;

        int views = (flags & (1 << 10)) != 0 ? IntPrimitive.read(bytes).getValue() : 0;
        int forwards = (flags & (1 << 10)) != 0 ? IntPrimitive.read(bytes).getValue() : 0;
        TlObject replies = (flags & (1 << 23)) != 0 ? TlObject.read(bytes) : null;
        int edit_date = (flags & (1 << 15)) != 0 ? IntPrimitive.read(bytes).getValue() : 0;
        String post_author = (flags & (1 << 16)) != 0 ? StringPrimitive.read(bytes).getValue() : null;
        long grouped_id = (flags & (1 << 17)) != 0 ? LongPrimitive.read(bytes).getValue() : 0;
        TlObject reactions = (flags & (1 << 20)) != 0 ? TlObject.read(bytes) : null;

        ArrayList<TlObject> restriction_reason = (flags & (1 << 22)) != 0 ? VectorPrimitive.read(bytes).getValue() : null;
        int ttl_period = (flags & (1 << 25)) != 0 ? IntPrimitive.read(bytes).getValue() : 0;

        return new Message(id, peer_id, date, message, out, mentioned, media_unread, silent, post, from_scheduled, legacy, edit_hide, pinned,
                noforwards, from_id, fwd_from, via_bot_id, reply_to, media, reply_markup, entities, views, forwards, replies, edit_date,
                post_author, grouped_id, reactions, restriction_reason, ttl_period);
    }

    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
