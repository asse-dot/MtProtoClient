//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.chatlists;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.BytesPrimitive;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GetChatlistUpdates extends TlObject {

    public static final int ID = -1992190687;

    public TlObject chatlist;

    public GetChatlistUpdates(TlObject chatlist) {
        this.chatlist = chatlist;
    }

    public static GetChatlistUpdates read(ByteArrayInputStream bytes) throws IOException {
        TlObject chatlist = TlObject.read(bytes);
		
		return new GetChatlistUpdates(chatlist);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.chatlist.write());
		
		return bOut.toByteArray();
    }
}
