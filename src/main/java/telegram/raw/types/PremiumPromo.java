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

public class PremiumPromo extends TlObject {

    public static final int ID = 1395946908;

    public String status_text;
	public ArrayList<TlObject> status_entities;
	public ArrayList<TlObject> video_sections;
	public ArrayList<TlObject> videos;
	public ArrayList<TlObject> period_options;
	public ArrayList<TlObject> users;

    public PremiumPromo(String status_text, ArrayList<TlObject> status_entities, ArrayList<TlObject> video_sections, ArrayList<TlObject> videos, ArrayList<TlObject> period_options, ArrayList<TlObject> users) {
        this.status_text = status_text;
		this.status_entities = status_entities;
		this.video_sections = video_sections;
		this.videos = videos;
		this.period_options = period_options;
		this.users = users;
    }

    public static PremiumPromo read(ByteArrayInputStream bytes) throws IOException {
        String status_text = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> status_entities = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> video_sections = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> videos = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> period_options = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new PremiumPromo(status_text, status_entities, video_sections, videos, period_options, users);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.status_text).write());
		bOut.write(new VectorPrimitive(this.status_entities).write());
		bOut.write(new VectorPrimitive(this.video_sections).write());
		bOut.write(new VectorPrimitive(this.videos).write());
		bOut.write(new VectorPrimitive(this.period_options).write());
		bOut.write(new VectorPrimitive(this.users).write());
		
		return bOut.toByteArray();
    }
}
