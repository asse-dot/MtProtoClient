//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types;

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

public class ChannelAdminLogEventActionExportedInviteRevoke extends TlObject {

    public static final int ID = 1091179342;

    public TlObject invite;

    public ChannelAdminLogEventActionExportedInviteRevoke(TlObject invite) {
        this.invite = invite;
    }

    public static ChannelAdminLogEventActionExportedInviteRevoke read(ByteArrayInputStream bytes) throws IOException {
        TlObject invite = TlObject.read(bytes);
		
		return new ChannelAdminLogEventActionExportedInviteRevoke(invite);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.invite.write());
		
		return bOut.toByteArray();
    }
}
