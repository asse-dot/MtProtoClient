package telegram.raw.core;

import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Message extends TlObject{

    public long message_id;
    public int seq_no;
    public int message_data_length;
    public TlObject body;

    public Message(TlObject data, long message_id, int seq_no, int message_data_length) {

        this.body = data;
        this.message_id = message_id;
        this.seq_no = seq_no;
        this.message_data_length = message_data_length;
    }

    public TlObject getBody() {
        return this.body;
    }

    public static Message read(ByteArrayInputStream bytes) throws IOException {

        long message_id = LongPrimitive.read(bytes).getValue();
        int seq_no = IntPrimitive.read(bytes).getValue();
        int message_data_length = IntPrimitive.read(bytes).getValue();
        TlObject data = TlObject.read(bytes);

        return new Message(data, message_id, seq_no, message_data_length);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new LongPrimitive(this.message_id).write());
        bOut.write(new IntPrimitive(this.seq_no).write());
        bOut.write(new IntPrimitive(this.message_data_length).write());
        bOut.write(this.body.write());

        return bOut.toByteArray();
    }
}
