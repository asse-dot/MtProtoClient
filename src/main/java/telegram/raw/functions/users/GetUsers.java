package telegram.raw.functions.users;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.types.InputUser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GetUsers extends TlObject {

    private final int ID = 0xd91a548;

    public ArrayList<TlObject> id;

    public GetUsers(ArrayList<TlObject> id) {
        this.id = id;
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new VectorPrimitive(this.id).write());

        return bOut.toByteArray();
    }
}
