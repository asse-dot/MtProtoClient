//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.help;

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

public class UserInfo extends TlObject {

    public static final int ID = 32192344;

    public String message;
	public ArrayList<TlObject> entities;
	public String author;
	public int date;

    public UserInfo(String message, ArrayList<TlObject> entities, String author, int date) {
        this.message = message;
		this.entities = entities;
		this.author = author;
		this.date = date;
    }

    public static UserInfo read(ByteArrayInputStream bytes) throws IOException {
        String message = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> entities = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		String author = StringPrimitive.read(bytes).getValue();
		int date = IntPrimitive.read(bytes).getValue();
		
		return new UserInfo(message, entities, author, date);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.message).write());
		bOut.write(new VectorPrimitive(this.entities).write());
		bOut.write(new StringPrimitive(this.author).write());
		bOut.write(new IntPrimitive(this.date).write());
		
		return bOut.toByteArray();
    }
}
