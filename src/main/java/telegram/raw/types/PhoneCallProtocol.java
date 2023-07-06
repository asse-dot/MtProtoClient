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

public class PhoneCallProtocol extends TlObject {

    public static final int ID = -58224696;

    public boolean udp_p2p;
	public boolean udp_reflector;
	public int min_layer;
	public int max_layer;
	public ArrayList<TlObject> library_versions;

    public PhoneCallProtocol(boolean udp_p2p, boolean udp_reflector, int min_layer, int max_layer, ArrayList<TlObject> library_versions) {
        this.udp_p2p = udp_p2p;
		this.udp_reflector = udp_reflector;
		this.min_layer = min_layer;
		this.max_layer = max_layer;
		this.library_versions = library_versions;
    }

    public static PhoneCallProtocol read(ByteArrayInputStream bytes) throws IOException {
        int flags = IntPrimitive.read(bytes).getValue();
		boolean udp_p2p = (flags & (1 << 0)) != 0;
		boolean udp_reflector = (flags & (1 << 1)) != 0;
		int min_layer = IntPrimitive.read(bytes).getValue();
		int max_layer = IntPrimitive.read(bytes).getValue();
		ArrayList<TlObject> library_versions = ((VectorPrimitive)TlObject.read(bytes)).getValue();
		
		return new PhoneCallProtocol(udp_p2p, udp_reflector, min_layer, max_layer, library_versions);
    }

    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		
		bOut.write(new IntPrimitive(ID).write());
		int flags = 0;
		flags |= this.udp_p2p ? (1 << 0) : 0;
		flags |= this.udp_reflector ? (1 << 1) : 0;
		
		
		bOut.write(new IntPrimitive(flags).write());
		bOut.write(new IntPrimitive(this.min_layer).write());
		bOut.write(new IntPrimitive(this.max_layer).write());
		bOut.write(new VectorPrimitive(this.library_versions).write());
		
		return bOut.toByteArray();
    }
}
