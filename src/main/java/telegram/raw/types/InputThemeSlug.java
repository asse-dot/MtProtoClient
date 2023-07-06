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

public class InputThemeSlug extends TlObject {

    public static final int ID = -175567375;

    public String slug;

    public InputThemeSlug(String slug) {
        this.slug = slug;
    }

    public static InputThemeSlug read(ByteArrayInputStream bytes) throws IOException {
        String slug = StringPrimitive.read(bytes).getValue();
		
		return new InputThemeSlug(slug);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(new StringPrimitive(this.slug).write());
		
		return bOut.toByteArray();
    }
}
