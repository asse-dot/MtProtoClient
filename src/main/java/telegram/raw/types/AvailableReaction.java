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

public class AvailableReaction extends TlObject {

    public static final int ID = -1065882623;

    public boolean inactive;
	public boolean premium;
	public String reaction;
	public String title;
	public TlObject static_icon;
	public TlObject appear_animation;
	public TlObject select_animation;
	public TlObject activate_animation;
	public TlObject effect_animation;
	public TlObject around_animation;
	public TlObject center_icon;

    public AvailableReaction(boolean inactive, boolean premium, String reaction, String title, TlObject static_icon, TlObject appear_animation, TlObject select_animation, TlObject activate_animation, TlObject effect_animation, TlObject around_animation, TlObject center_icon) {
        this.inactive = inactive;
		this.premium = premium;
		this.reaction = reaction;
		this.title = title;
		this.static_icon = static_icon;
		this.appear_animation = appear_animation;
		this.select_animation = select_animation;
		this.activate_animation = activate_animation;
		this.effect_animation = effect_animation;
		this.around_animation = around_animation;
		this.center_icon = center_icon;
    }

    public static AvailableReaction read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean inactive = (flags & (1 << 0)) != 0;
		boolean premium = (flags & (1 << 2)) != 0;
		String reaction = StringPrimitive.read(bytes).getValue();
		String title = StringPrimitive.read(bytes).getValue();
		TlObject static_icon = TlObject.read(bytes);
		TlObject appear_animation = TlObject.read(bytes);
		TlObject select_animation = TlObject.read(bytes);
		TlObject activate_animation = TlObject.read(bytes);
		TlObject effect_animation = TlObject.read(bytes);
		TlObject around_animation = (flags & (1 << 1)) != 0 ?  TlObject.read(bytes) : null;
		TlObject center_icon = (flags & (1 << 1)) != 0 ?  TlObject.read(bytes) : null;
		
		return new AvailableReaction(inactive, premium, reaction, title, static_icon, appear_animation, select_animation, activate_animation, effect_animation, around_animation, center_icon);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.inactive ? (1 << 0) : 0;
		flags |= this.premium ? (1 << 2) : 0;
		flags |= (this.around_animation != null) ? (1 << 1) : 0;
		flags |= (this.center_icon != null) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new StringPrimitive(this.reaction).write());
		bOut.write(new StringPrimitive(this.title).write());
		bOut.write(this.static_icon.write());
		bOut.write(this.appear_animation.write());
		bOut.write(this.select_animation.write());
		bOut.write(this.activate_animation.write());
		bOut.write(this.effect_animation.write());
		if(this.around_animation != null)
			bOut.write(this.around_animation.write());
		if(this.center_icon != null)
			bOut.write(this.center_icon.write());
		
		return bOut.toByteArray();
    }
}
