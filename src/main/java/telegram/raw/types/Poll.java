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

public class Poll extends TlObject {

    public static final int ID = -2032041631;

    public long id;
	public boolean closed;
	public boolean public_voters;
	public boolean multiple_choice;
	public boolean quiz;
	public String question;
	public ArrayList<TlObject> answers;
	public int close_period;
	public int close_date;

    public Poll(long id, boolean closed, boolean public_voters, boolean multiple_choice, boolean quiz, String question, ArrayList<TlObject> answers, int close_period, int close_date) {
        this.id = id;
		this.closed = closed;
		this.public_voters = public_voters;
		this.multiple_choice = multiple_choice;
		this.quiz = quiz;
		this.question = question;
		this.answers = answers;
		this.close_period = close_period;
		this.close_date = close_date;
    }

    public static Poll read(ByteArrayInputStream bytes) throws IOException {
        long id = LongPrimitive.read(bytes).getValue();
		int flags = IntPrimitive.read(bytes).getValue();
		boolean closed = (flags & (1 << 0)) != 0;
		boolean public_voters = (flags & (1 << 1)) != 0;
		boolean multiple_choice = (flags & (1 << 2)) != 0;
		boolean quiz = (flags & (1 << 3)) != 0;
		String question = StringPrimitive.read(bytes).getValue();
		ArrayList<TlObject> answers = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		int close_period = (flags & (1 << 4)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		int close_date = (flags & (1 << 5)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		
		return new Poll(id, closed, public_voters, multiple_choice, quiz, question, answers, close_period, close_date);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.closed ? (1 << 0) : 0;
		flags |= this.public_voters ? (1 << 1) : 0;
		flags |= this.multiple_choice ? (1 << 2) : 0;
		flags |= this.quiz ? (1 << 3) : 0;
		flags |= (this.close_period != 0) ? (1 << 4) : 0;
		flags |= (this.close_date != 0) ? (1 << 5) : 0;
		
		
		bOut.write(new LongPrimitive(this.id).write());
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new StringPrimitive(this.question).write());
		bOut.write(new VectorPrimitive(this.answers).write());
		if(this.close_period != 0)
			bOut.write(new IntPrimitive(this.close_period).write());
		if(this.close_date != 0)
			bOut.write(new IntPrimitive(this.close_date).write());
		
		return bOut.toByteArray();
    }
}
