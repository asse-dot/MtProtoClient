package telegram.raw.functions;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InitConnection extends TlObject{

//    self.api_id = api_id  # int
//    self.device_model = device_model  # string
//    self.system_version = system_version  # string
//    self.app_version = app_version  # string
//    self.system_lang_code = system_lang_code  # string
//    self.lang_pack = lang_pack  # string
//    self.lang_code = lang_code  # string
//    self.query = query  # !X

    private final int ID = 0xc1cd5ea9;

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
        bOut.write(new IntPrimitive(this.ID).write());
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
