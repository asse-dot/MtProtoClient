package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class User extends TlObject {

    private final int ID = 0x8f97c628;

    public long id;
    public boolean is_self;
    public boolean contact;
    public boolean mutual_contact;
    public boolean deleted;
    public boolean bot;
    public boolean bot_chat_history;
    public boolean bot_nochats;
    public boolean verified;
    public boolean restricted;
    public boolean min;
    public boolean bot_inline_geo;
    public boolean support;
    public boolean scam;
    public boolean apply_min_photo;
    public boolean fake;
    public boolean bot_attach_menu;
    public boolean premium;
    public boolean attach_menu_enabled;
    public boolean bot_can_edit;
    public long access_hash;
    public String first_name;
    public String last_name;
    public String username;
    public String phone;
    public TlObject photo;
    public TlObject status;
    public int bot_info_version;
    public TlObject restriction_reason;
    public String bot_inline_placeholder;
    public String lang_code;
    public TlObject emoji_status;
    public ArrayList<TlObject> usernames;

    public User(long id, boolean is_self, boolean contact, boolean mutual_contact, boolean deleted, boolean bot, boolean bot_chat_history, boolean bot_nochats, boolean verified, boolean restricted, boolean min, boolean bot_inline_geo, boolean support, boolean scam, boolean apply_min_photo, boolean fake, boolean bot_attach_menu, boolean premium, boolean attach_menu_enabled, boolean bot_can_edit, long access_hash, String first_name, String last_name, String username, String phone, TlObject photo, TlObject status, int bot_info_version, TlObject restriction_reason, String bot_inline_placeholder, String lang_code, TlObject emoji_status, ArrayList<TlObject> usernames) {
        this.id = id;
        this.is_self = is_self;
        this.contact = contact;
        this.mutual_contact = mutual_contact;
        this.deleted = deleted;
        this.bot = bot;
        this.bot_chat_history = bot_chat_history;
        this.bot_nochats = bot_nochats;
        this.verified = verified;
        this.restricted = restricted;
        this.min = min;
        this.bot_inline_geo = bot_inline_geo;
        this.support = support;
        this.scam = scam;
        this.apply_min_photo = apply_min_photo;
        this.fake = fake;
        this.bot_attach_menu = bot_attach_menu;
        this.premium = premium;
        this.attach_menu_enabled = attach_menu_enabled;
        this.bot_can_edit = bot_can_edit;
        this.access_hash = access_hash;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.phone = phone;
        this.photo = photo;
        this.status = status;
        this.bot_info_version = bot_info_version;
        this.restriction_reason = restriction_reason;
        this.bot_inline_placeholder = bot_inline_placeholder;
        this.lang_code = lang_code;
        this.emoji_status = emoji_status;
        this.usernames = usernames;
    }

    public static User read(ByteArrayInputStream bytes) throws IOException {

        int flags = IntPrimitive.read(bytes).getValue();

        boolean is_self = (flags & (1 << 10)) != 0;
        boolean contact = (flags & (1 << 11)) != 0;
        boolean mutual_contact = (flags & (1 << 12)) != 0;
        boolean deleted = (flags & (1 << 13)) != 0;
        boolean bot = (flags & (1 << 14)) != 0;
        boolean bot_chat_history = (flags & (1 << 15)) != 0;
        boolean bot_nochats = (flags & (1 << 16)) != 0;
        boolean verified = (flags & (1 << 17)) != 0;
        boolean restricted = (flags & (1 << 18)) != 0;
        boolean min = (flags & (1 << 20)) != 0;
        boolean bot_inline_geo = (flags & (1 << 21)) != 0;
        boolean support = (flags & (1 << 23)) != 0;
        boolean scam = (flags & (1 << 24)) != 0;
        boolean apply_min_photo = (flags & (1 << 25)) != 0;
        boolean fake = (flags & (1 << 26)) != 0;
        boolean bot_attach_menu = (flags & (1 << 27)) != 0;
        boolean premium = (flags & (1 << 28)) != 0;
        boolean attach_menu_enabled = (flags & (1 << 29)) != 0;

        int flags2 = IntPrimitive.read(bytes).getValue();

        boolean bot_can_edit = (flags2 & (1 << 1)) != 0;

        long id = LongPrimitive.read(bytes).getValue();
        long access_hash = (flags & (1 << 0)) != 0 ? LongPrimitive.read(bytes).getValue() : 0;
        String first_name =(flags & (1 << 1)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
        String last_name = (flags & (1 << 2)) != 0 ? StringPrimitive.read(bytes).getValue() : null;
        String username = (flags & (1 << 3)) != 0 ? StringPrimitive.read(bytes).getValue() : null;
        String phone = (flags & (1 << 4)) != 0 ? StringPrimitive.read(bytes).getValue() : null;
        TlObject photo = (flags & (1 << 5)) != 0 ? TlObject.read(bytes) : null;
        TlObject status = (flags & (1 << 6)) != 0 ? TlObject.read(bytes) : null;
        int bot_info_version = (flags & (1 << 14)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
        TlObject restriction_reason = (flags & (1 << 18)) != 0 ? TlObject.read(bytes) : null;
        String bot_inline_placeholder = (flags & (1 << 19)) != 0 ? StringPrimitive.read(bytes).getValue() : null;
        String lang_code = (flags & (1 << 22)) != 0 ? StringPrimitive.read(bytes).getValue() : null;
        TlObject emoji_status = (flags & (1 << 30)) != 0 ?  TlObject.read(bytes) : null;
        ArrayList<TlObject> usernames = (flags2 & (1 << 0)) != 0 ? VectorPrimitive.read(bytes).getValue() : null;

        return new User(id, is_self, contact, mutual_contact, deleted, bot, bot_chat_history, bot_nochats, verified, restricted, min,
                bot_inline_geo, support, scam, apply_min_photo, fake, bot_attach_menu, premium, attach_menu_enabled, bot_can_edit, access_hash,
                first_name, last_name, username, phone, photo, status, bot_info_version, restriction_reason, bot_inline_placeholder, lang_code, emoji_status, usernames);
    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
