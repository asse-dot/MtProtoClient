package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Updates extends TlObject {

    public static final int ID = 0x74ae4240;

    public ArrayList<TlObject> updates;
    public ArrayList<TlObject> users;
    public ArrayList<TlObject> chats;
    public int date;
    public int seq;

    public Updates(ArrayList<TlObject> updates, ArrayList<TlObject> users, ArrayList<TlObject> chats, int date, int seq) {
        this.updates = updates;
        this.users = users;
        this.chats = chats;
        this.date = date;
        this.seq = seq;
    }

    public static Updates read(ByteArrayInputStream bytes) throws IOException {
        ArrayList<TlObject> updates = ((VectorPrimitive) TlObject.read(bytes)).getValue();
        ArrayList<TlObject> users = ((VectorPrimitive) TlObject.read(bytes)).getValue();
        ArrayList<TlObject> chats = ((VectorPrimitive) TlObject.read(bytes)).getValue();
        int date = IntPrimitive.read(bytes).getValue();
        int seq = IntPrimitive.read(bytes).getValue();

        return new Updates(updates, users, chats, date, seq);

    }


    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
