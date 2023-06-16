package telegram.raw.functions.messages;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;
import telegram.raw.types.InputPeerUser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SendMessage extends TlObject {

    private final int ID = 0x1cc20387;

    //TODO DA SISTEMARE PER TUTTI GLI INPUTPEER (CHAT, USER ETC..)
    public InputPeerUser peer;
    public String message;
    public long random_id;

    public SendMessage(InputPeerUser peer, String message, long random_id) {
        this.peer = peer;
        this.message = message;
        this.random_id = random_id;
    }

    //TODO read

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        int flags = 0;

        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new IntPrimitive(flags).write());
        bOut.write(peer.write());
        bOut.write(new StringPrimitive(this.message).write());
        bOut.write(new LongPrimitive(this.random_id).write());

        return bOut.toByteArray();
    }
}
