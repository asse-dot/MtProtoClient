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

public class InputBotInlineMessageMediaInvoice extends TlObject {

    public static final int ID = -672693723;

    public String title;
	public String description;
	public TlObject photo;
	public TlObject invoice;
	public byte[] payload;
	public String provider;
	public TlObject provider_data;
	public TlObject reply_markup;

    public InputBotInlineMessageMediaInvoice(String title, String description, TlObject photo, TlObject invoice, byte[] payload, String provider, TlObject provider_data, TlObject reply_markup) {
        this.title = title;
		this.description = description;
		this.photo = photo;
		this.invoice = invoice;
		this.payload = payload;
		this.provider = provider;
		this.provider_data = provider_data;
		this.reply_markup = reply_markup;
    }

    public static InputBotInlineMessageMediaInvoice read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		String title = StringPrimitive.read(bytes).getValue();
		String description = StringPrimitive.read(bytes).getValue();
		TlObject photo = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		TlObject invoice = TlObject.read(bytes);
		byte[] payload = BytesPrimitive.read(bytes).getValue();
		String provider = StringPrimitive.read(bytes).getValue();
		TlObject provider_data = TlObject.read(bytes);
		TlObject reply_markup = (flags & (1 << 2)) != 0 ?  TlObject.read(bytes) : null;
		
		return new InputBotInlineMessageMediaInvoice(title, description, photo, invoice, payload, provider, provider_data, reply_markup);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.photo != null) ? (1 << 0) : 0;
		flags |= (this.reply_markup != null) ? (1 << 2) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new StringPrimitive(this.title).write());
		bOut.write(new StringPrimitive(this.description).write());
		if(this.photo != null)
			bOut.write(this.photo.write());
		bOut.write(this.invoice.write());
		bOut.write(new BytesPrimitive(this.payload).write());
		bOut.write(new StringPrimitive(this.provider).write());
		bOut.write(this.provider_data.write());
		if(this.reply_markup != null)
			bOut.write(this.reply_markup.write());
		
		return bOut.toByteArray();
    }
}
