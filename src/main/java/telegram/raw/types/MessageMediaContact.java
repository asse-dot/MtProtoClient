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

public class MessageMediaContact extends TlObject {

    public static final int ID = 1882335561;

    public String phone_number;
	public String first_name;
	public String last_name;
	public String vcard;
	public long user_id;

    public MessageMediaContact(String phone_number, String first_name, String last_name, String vcard, long user_id) {
        this.phone_number = phone_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.vcard = vcard;
		this.user_id = user_id;
    }

    public static MessageMediaContact read(ByteArrayInputStream bytes) throws IOException {
        String phone_number = StringPrimitive.read(bytes).getValue();
		String first_name = StringPrimitive.read(bytes).getValue();
		String last_name = StringPrimitive.read(bytes).getValue();
		String vcard = StringPrimitive.read(bytes).getValue();
		long user_id = LongPrimitive.read(bytes).getValue();
		
		return new MessageMediaContact(phone_number, first_name, last_name, vcard, user_id);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.phone_number).write());
		bOut.write(new StringPrimitive(this.first_name).write());
		bOut.write(new StringPrimitive(this.last_name).write());
		bOut.write(new StringPrimitive(this.vcard).write());
		bOut.write(new LongPrimitive(this.user_id).write());
		
		return bOut.toByteArray();
    }
}
