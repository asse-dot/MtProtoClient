//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.functions.langpack;

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

public class GetLanguage extends TlObject {

    public static final int ID = 1784243458;

    public String lang_pack;
	public String lang_code;

    public GetLanguage(String lang_pack, String lang_code) {
        this.lang_pack = lang_pack;
		this.lang_code = lang_code;
    }

    public static GetLanguage read(ByteArrayInputStream bytes) throws IOException {
        String lang_pack = StringPrimitive.read(bytes).getValue();
		String lang_code = StringPrimitive.read(bytes).getValue();
		
		return new GetLanguage(lang_pack, lang_code);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.lang_pack).write());
		bOut.write(new StringPrimitive(this.lang_code).write());
		
		return bOut.toByteArray();
    }
}
