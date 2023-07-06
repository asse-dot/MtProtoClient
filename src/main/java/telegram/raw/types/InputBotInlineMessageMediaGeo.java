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

public class InputBotInlineMessageMediaGeo extends TlObject {

    public static final int ID = -1768777083;

    public TlObject geo_point;
	public int heading;
	public int period;
	public int proximity_notification_radius;
	public TlObject reply_markup;

    public InputBotInlineMessageMediaGeo(TlObject geo_point, int heading, int period, int proximity_notification_radius, TlObject reply_markup) {
        this.geo_point = geo_point;
		this.heading = heading;
		this.period = period;
		this.proximity_notification_radius = proximity_notification_radius;
		this.reply_markup = reply_markup;
    }

    public static InputBotInlineMessageMediaGeo read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		TlObject geo_point = TlObject.read(bytes);
		int heading = (flags & (1 << 0)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		int period = (flags & (1 << 1)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		int proximity_notification_radius = (flags & (1 << 3)) != 0 ?  IntPrimitive.read(bytes).getValue() : 0;
		TlObject reply_markup = (flags & (1 << 2)) != 0 ?  TlObject.read(bytes) : null;
		
		return new InputBotInlineMessageMediaGeo(geo_point, heading, period, proximity_notification_radius, reply_markup);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.heading != 0) ? (1 << 0) : 0;
		flags |= (this.period != 0) ? (1 << 1) : 0;
		flags |= (this.proximity_notification_radius != 0) ? (1 << 3) : 0;
		flags |= (this.reply_markup != null) ? (1 << 2) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(this.geo_point.write());
		if(this.heading != 0)
			bOut.write(new IntPrimitive(this.heading).write());
		if(this.period != 0)
			bOut.write(new IntPrimitive(this.period).write());
		if(this.proximity_notification_radius != 0)
			bOut.write(new IntPrimitive(this.proximity_notification_radius).write());
		if(this.reply_markup != null)
			bOut.write(this.reply_markup.write());
		
		return bOut.toByteArray();
    }
}
