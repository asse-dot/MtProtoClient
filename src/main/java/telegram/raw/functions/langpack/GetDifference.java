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

public class GetDifference extends TlObject {

    public static final int ID = -845657435;

    public String lang_pack;
	public String lang_code;
	public int from_version;

    public GetDifference(String lang_pack, String lang_code, int from_version) {
        this.lang_pack = lang_pack;
		this.lang_code = lang_code;
		this.from_version = from_version;
    }

    public static GetDifference read(ByteArrayInputStream bytes) throws IOException {
        String lang_pack = StringPrimitive.read(bytes).getValue();
		String lang_code = StringPrimitive.read(bytes).getValue();
		int from_version = IntPrimitive.read(bytes).getValue();
		
		return new GetDifference(lang_pack, lang_code, from_version);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.lang_pack).write());
		bOut.write(new StringPrimitive(this.lang_code).write());
		bOut.write(new IntPrimitive(this.from_version).write());
		
		return bOut.toByteArray();
    }
}
