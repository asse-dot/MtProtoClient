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

public class InputMediaGeoPoint extends TlObject {

    public static final int ID = -104578748;

    public TlObject geo_point;

    public InputMediaGeoPoint(TlObject geo_point) {
        this.geo_point = geo_point;
    }

    public static InputMediaGeoPoint read(ByteArrayInputStream bytes) throws IOException {
        TlObject geo_point = TlObject.read(bytes);
		
		return new InputMediaGeoPoint(geo_point);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		bOut.write(this.geo_point.write());
		
		return bOut.toByteArray();
    }
}
