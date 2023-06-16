package telegram.raw.types;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RpcResult extends TlObject {

    private final int ID = 0xf35c6d01;

    public long req_msg_id;
    public TlObject result;

    public RpcResult(long req_msg_id, TlObject result) {
        this.req_msg_id = req_msg_id;
        this.result = result;
    }

    public static RpcResult read(ByteArrayInputStream bytes) throws IOException {
        long req_msg_id = LongPrimitive.read(bytes).getValue();
        TlObject result = TlObject.read(bytes);

        return new RpcResult(req_msg_id, result);
    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        return new byte[0];
    }
}
