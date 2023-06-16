package telegram.raw.functions.auth;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImportBotAuthorization extends TlObject {

    private final int ID = 0x67a3ff2c;

    public int flags;
    public int api_id;
    public String api_hash;
    public String bot_auth_token;

    public ImportBotAuthorization(int flags, int api_id, String api_hash, String bot_auth_token) {
        this.flags = flags;
        this.api_id = api_id;
        this.api_hash = api_hash;
        this.bot_auth_token = bot_auth_token;
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new IntPrimitive(this.flags).write());
        bOut.write(new IntPrimitive(this.api_id).write());
        bOut.write(new StringPrimitive(this.api_hash).write());
        bOut.write(new StringPrimitive(this.bot_auth_token).write());

        return bOut.toByteArray();
    }
}
