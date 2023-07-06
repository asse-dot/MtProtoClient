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

public class PremiumGiftOption extends TlObject {

    public static final int ID = 1958953753;

    public int months;
	public String currency;
	public long amount;
	public String bot_url;
	public String store_product;

    public PremiumGiftOption(int months, String currency, long amount, String bot_url, String store_product) {
        this.months = months;
		this.currency = currency;
		this.amount = amount;
		this.bot_url = bot_url;
		this.store_product = store_product;
    }

    public static PremiumGiftOption read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		int months = IntPrimitive.read(bytes).getValue();
		String currency = StringPrimitive.read(bytes).getValue();
		long amount = LongPrimitive.read(bytes).getValue();
		String bot_url = StringPrimitive.read(bytes).getValue();
		String store_product = (flags & (1 << 0)) != 0 ?  StringPrimitive.read(bytes).getValue() : null;
		
		return new PremiumGiftOption(months, currency, amount, bot_url, store_product);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= (this.store_product != null) ? (1 << 0) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new IntPrimitive(this.months).write());
		bOut.write(new StringPrimitive(this.currency).write());
		bOut.write(new LongPrimitive(this.amount).write());
		bOut.write(new StringPrimitive(this.bot_url).write());
		if(this.store_product != null)
			bOut.write(new StringPrimitive(this.store_product).write());
		
		return bOut.toByteArray();
    }
}
