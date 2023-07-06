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

public class GetStrings extends TlObject {

    public static final int ID = -269862909;

    public String lang_pack;
	public String lang_code;
	public ArrayList<TlObject> keys;

    public GetStrings(String lang_pack, String lang_code, ArrayList<TlObject> keys) {
        this.lang_pack = lang_pack;
		this.lang_code = lang_code;
		this.keys = keys;
    }

    public static GetStrings read(ByteArrayInputStream bytes) throws IOException {
        String lang_pack = StringPrimitive.read(bytes).getValue();
		String lang_code = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> keys = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new GetStrings(lang_pack, lang_code, keys);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.lang_pack).write());
		bOut.write(new StringPrimitive(this.lang_code).write());
		bOut.write(new VectorPrimitive(this.keys).write());
		
		return bOut.toByteArray();
    }
}
