package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BadServerSalt extends TlObject {

    public  static final int ID = 0xedab447b;

    public long bad_msg_id;
    public int bad_msg_seqno;
    public int error_code;
    public long new_server_salt;

    public BadServerSalt(long bad_msg_id, int bad_msg_seqno, int error_code, long new_server_salt) {
        this.bad_msg_id = bad_msg_id;
        this.bad_msg_seqno = bad_msg_seqno;
        this.error_code = error_code;
        this.new_server_salt = new_server_salt;
    }

    public static BadServerSalt read(ByteArrayInputStream bytes) throws IOException {
        long bad_msg_id = LongPrimitive.read(bytes).getValue();
        int bad_msg_seq_no = IntPrimitive.read(bytes).getValue();
        int error_code = IntPrimitive.read(bytes).getValue();
        long new_server_salt = LongPrimitive.read(bytes).getValue();

        return new BadServerSalt(bad_msg_id, bad_msg_seq_no, error_code, new_server_salt);
    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
