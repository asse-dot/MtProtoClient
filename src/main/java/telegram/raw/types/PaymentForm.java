//this is an autogenerated file!!
//!!!!!!!!!!
package telegram.raw.types.payments;

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

public class PaymentForm extends TlObject {

    public static final int ID = -1610250415;

    public boolean can_save_credentials;
	public boolean password_missing;
	public long form_id;
	public long bot_id;
	public String title;
	public String description;
	public TlObject photo;
	public TlObject invoice;
	public long provider_id;
	public String url;
	public String native_provider;
	public TlObject native_params;
	public ArrayList<TlObject> additional_methods;
	public TlObject saved_info;
	public ArrayList<TlObject> saved_credentials;
	public ArrayList<TlObject> users;

    public PaymentForm(boolean can_save_credentials, boolean password_missing, long form_id, long bot_id, String title, String description, TlObject photo, TlObject invoice, long provider_id, String url, String native_provider, TlObject native_params, ArrayList<TlObject> additional_methods, TlObject saved_info, ArrayList<TlObject> saved_credentials, ArrayList<TlObject> users) {
        this.can_save_credentials = can_save_credentials;
		this.password_missing = password_missing;
		this.form_id = form_id;
		this.bot_id = bot_id;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.invoice = invoice;
		this.provider_id = provider_id;
		this.url = url;
		this.native_provider = native_provider;
		this.native_params = native_params;
		this.additional_methods = additional_methods;
		this.saved_info = saved_info;
		this.saved_credentials = saved_credentials;
		this.users = users;
    }

    public static PaymentForm read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean can_save_credentials = (flags & (1 << 2)) != 0;
		boolean password_missing = (flags & (1 << 3)) != 0;
		long form_id = LongPrimitive.read(bytes).getValue();
		long bot_id = LongPrimitive.read(bytes).getValue();
		String title = StringPrimitive.read(bytes).getValue();
		String description = StringPrimitive.read(bytes).getValue();
		TlObject photo = (flags & (1 << 5)) != 0 ?  TlObject.read(bytes) : null;
		TlObject invoice = TlObject.read(bytes);
		long provider_id = LongPrimitive.read(bytes).getValue();
		String url = StringPrimitive.read(bytes).getValue();
		String native_provider = (flags & (1 << 4)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		TlObject native_params = (flags & (1 << 4)) != 0 ?  TlObject.read(bytes) : null;
		ArrayList<TlObject> additional_methods = (flags & (1 << 6)) != 0 ?  ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;
		TlObject saved_info = (flags & (1 << 0)) != 0 ?  TlObject.read(bytes) : null;
		ArrayList<TlObject> saved_credentials = (flags & (1 << 1)) != 0 ?  ((VectorPrimitive)TlObject.read(bytes)).getValue() : null;
		ArrayList<TlObject> users = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new PaymentForm(can_save_credentials, password_missing, form_id, bot_id, title, description, photo, invoice, provider_id, url, native_provider, native_params, additional_methods, saved_info, saved_credentials, users);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.can_save_credentials ? (1 << 2) : 0;
		flags |= this.password_missing ? (1 << 3) : 0;
		flags |= (this.photo != null) ? (1 << 5) : 0;
		flags |= (this.native_provider != null) ? (1 << 4) : 0;
		flags |= (this.native_params != null) ? (1 << 4) : 0;
		flags |= (this.additional_methods != null) ? (1 << 6) : 0;
		flags |= (this.saved_info != null) ? (1 << 0) : 0;
		flags |= (this.saved_credentials != null) ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new LongPrimitive(this.form_id).write());
		bOut.write(new LongPrimitive(this.bot_id).write());
		bOut.write(new StringPrimitive(this.title).write());
		bOut.write(new StringPrimitive(this.description).write());
		if(this.photo != null)
			bOut.write(this.photo.write());
		bOut.write(this.invoice.write());
		bOut.write(new LongPrimitive(this.provider_id).write());
		bOut.write(new StringPrimitive(this.url).write());
		if(this.native_provider != null)
			bOut.write(new StringPrimitive(this.native_provider).write());
		if(this.native_params != null)
			bOut.write(this.native_params.write());
		if(this.additional_methods != null)
			bOut.write(new VectorPrimitive(this.additional_methods).write());
		if(this.saved_info != null)
			bOut.write(this.saved_info.write());
		if(this.saved_credentials != null)
			bOut.write(new VectorPrimitive(this.saved_credentials).write());
		bOut.write(new VectorPrimitive(this.users).write());
		
		return bOut.toByteArray();
    }
}
