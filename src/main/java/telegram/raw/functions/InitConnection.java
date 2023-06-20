package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InitConnection extends TlObject{

    public static final int ID = 0xc1cd5ea9;

    public int api_id;
    public String device_model;
    public String system_version;
    public String app_version;
    public String system_lang_code;
    public String lang_pack;
    public String lang_code;
    public TlObject query;

    public InitConnection(int api_id, String device_model, String system_version, String app_version, String system_lang_code, String lang_pack, String lang_code, TlObject query) {
        this.api_id = api_id;
        this.device_model = device_model;
        this.system_version = system_version;
        this.app_version = app_version;
        this.system_lang_code = system_lang_code;
        this.lang_pack = lang_pack;
        this.lang_code = lang_code;
        this.query = query;
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        int flags = 0;
        flags |= 0;
        flags |= 0;
        bOut.write(new IntPrimitive(ID).write());
        bOut.write(new IntPrimitive(flags).write()); //flags

        bOut.write(new IntPrimitive(this.api_id).write());
        bOut.write(new StringPrimitive(this.device_model).write());
        bOut.write(new StringPrimitive(this.system_version).write());
        bOut.write(new StringPrimitive(this.app_version).write());
        bOut.write(new StringPrimitive(this.system_lang_code).write());
        bOut.write(new StringPrimitive(this.lang_pack).write());
        bOut.write(new StringPrimitive(this.lang_code).write());
        bOut.write(this.query.write());

        return bOut.toByteArray();
    }
}
