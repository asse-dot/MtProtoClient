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

public class PollAnswerVoters extends TlObject {

    public static final int ID = 997055186;

    public boolean chosen;
	public boolean correct;
	public byte[] option;
	public int voters;

    public PollAnswerVoters(boolean chosen, boolean correct, byte[] option, int voters) {
        this.chosen = chosen;
		this.correct = correct;
		this.option = option;
		this.voters = voters;
    }

    public static PollAnswerVoters read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean chosen = (flags & (1 << 0)) != 0;
		boolean correct = (flags & (1 << 1)) != 0;
		byte[] option = BytesPrimitive.read(bytes).getValue();
		int voters = IntPrimitive.read(bytes).getValue();
		
		return new PollAnswerVoters(chosen, correct, option, voters);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.chosen ? (1 << 0) : 0;
		flags |= this.correct ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new BytesPrimitive(this.option).write());
		bOut.write(new IntPrimitive(this.voters).write());
		
		return bOut.toByteArray();
    }
}
