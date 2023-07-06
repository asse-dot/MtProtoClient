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

public class InputReportReasonGeoIrrelevant extends TlObject {

    public static final int ID = -606798099;

    

    public InputReportReasonGeoIrrelevant() {
        
    }

    public static InputReportReasonGeoIrrelevant read(ByteArrayInputStream bytes) throws IOException {
        
		return new InputReportReasonGeoIrrelevant();
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		
		
		
		return bOut.toByteArray();
    }
}
