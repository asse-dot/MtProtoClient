package telegram.raw.core;

import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.functions.ReqPqMulti;
import telegram.raw.types.*;
import telegram.raw.types.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Vector;

public abstract class TlObject {

    public static HashMap<Integer, Class<TlObject>> objects = new HashMap<Integer, Class<TlObject>>();

    public abstract byte[] write() throws IOException;

    public static TlObject read(ByteArrayInputStream bytes) throws IOException {


        int id = IntPrimitive.read(bytes).getValue();
        System.out.println(Integer.toHexString(id));
        switch(id) {
            case 0x05162463:
                return ResPQ.read(bytes);
            case 0x1cb5c415:
                return VectorPrimitive.read(bytes);
            case 0xd0e8075c:
                return ServerDHParamsOk.read(bytes);
            case 0xb5890dba:
                return ServerDHInnerData.read(bytes);
            case 0xedab447b:
                return BadServerSalt.read(bytes);
            case 0xf35c6d01:
                return RpcResult.read(bytes);
            case 0x8f97c628:
                return User.read(bytes);
            case 0x74ae4240:
                return Updates.read(bytes);
            case 0x1f2b0afd:
                return UpdateNewMessage.read(bytes);
            case 0x38116ee0:
                return Message.read(bytes);
            case 0x59511722:
                return PeerUser.read(bytes);
        }
        return null;

    }

    public int getLength() {
        try {
            return this.write().length;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
