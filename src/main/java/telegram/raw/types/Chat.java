package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Chat extends TlObject {

    public static final int ID = 0x41cbf256;

    public long id;
    public String title;
    public TlObject photo;
    public int participants_count;
    public int date;
    public int version;
    public boolean creator;
    public boolean left;
    public boolean deactivated;
    public boolean call_active;
    public boolean call_not_empty;
    public boolean noforwards;
    public TlObject migrated_to;
    public TlObject admin_rights;
    public TlObject default_banned_rights;

    public Chat(long id, String title, TlObject photo, int participants_count, int date, int version, boolean creator, boolean left, boolean deactivated, boolean call_active, boolean call_not_empty, boolean noforwards, TlObject migrated_to, TlObject admin_rights, TlObject default_banned_rights) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.participants_count = participants_count;
        this.date = date;
        this.version = version;
        this.creator = creator;
        this.left = left;
        this.deactivated = deactivated;
        this.call_active = call_active;
        this.call_not_empty = call_not_empty;
        this.noforwards = noforwards;
        this.migrated_to = migrated_to;
        this.admin_rights = admin_rights;
        this.default_banned_rights = default_banned_rights;
    }

    public static Chat read(ByteArrayInputStream bytes) throws IOException {

        int flags = IntPrimitive.read(bytes).getValue();

        boolean creator = (flags & (1 <<0)) != 0;
        boolean left = (flags & (1 <<2)) != 0;
        boolean deactivated = (flags & (1 << 5)) != 0;
        boolean call_active = (flags & (1 <<23)) != 0;
        boolean call_not_empty = (flags & (1 <<24)) != 0;
        boolean noforwards = (flags & (1 <<25)) != 0;

        long id = LongPrimitive.read(bytes).getValue();
        String title = StringPrimitive.read(bytes).getValue();
        TlObject photo = TlObject.read(bytes);
        int participants_count = IntPrimitive.read(bytes).getValue();
        int date = IntPrimitive.read(bytes).getValue();
        int version = IntPrimitive.read(bytes).getValue();

        TlObject migrated_to = (flags & (1 <<6)) != 0 ? TlObject.read(bytes) : null;
        TlObject admin_rights = (flags & (1 <<14)) != 0 ? TlObject.read(bytes) : null;
        TlObject default_banned_rights = (flags & (1 <<18)) != 0 ? TlObject.read(bytes) : null;
        System.out.println(title);
        return new Chat(id, title, photo, participants_count, date, version, creator,
                left, deactivated, call_active, call_not_empty, noforwards, migrated_to, admin_rights, default_banned_rights);

    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
