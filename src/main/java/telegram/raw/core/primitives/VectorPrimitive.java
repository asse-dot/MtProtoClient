package telegram.raw.core.primitives;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class VectorPrimitive extends TlObject {

    private final int ID = 0x1cb5c415;

    private ArrayList<TlObject> value;

    public VectorPrimitive(ArrayList<TlObject> value) {
        this.value = value;
    }

    public ArrayList<TlObject> getValue() {
        return this.value;
    }

    public static TlObject read_bare(ByteArrayInputStream bytes, int size) throws IOException {
        if(size == 4) {
            return IntPrimitive.read(bytes);
        }

        if(size == 8) {
            return LongPrimitive.read(bytes);
        }

        return TlObject.read(bytes);
    }

    public static VectorPrimitive read(ByteArrayInputStream bytes) throws IOException {
        int length = IntPrimitive.read(bytes).getValue();

        if(length == 0) {
            return new VectorPrimitive(new ArrayList<TlObject>());
        }
        //System.out.println("length: " + length);


        int bytes_left = bytes.available();
        int size = bytes_left / length;

        ArrayList<TlObject> tList = new ArrayList<>();
        for(int i = 0; i<length; i++) {
            tList.add(read_bare(bytes, size));
        }

        return new VectorPrimitive(tList);
    }

    public ArrayList<Integer> asInt() {
        ArrayList<Integer> intList = new ArrayList<>();
        for(TlObject intPrimitive : this.value) {
            intList.add(((IntPrimitive)intPrimitive).getValue());
        }

        return intList;
    }

    public ArrayList<Long> asLong() {
        ArrayList<Long> longList = new ArrayList<>();
        for(TlObject longPrimitive : this.value) {
            longList.add(((LongPrimitive)longPrimitive).getValue());
        }

        return longList;
    }

    //TODO
    @Override
    public byte[] write() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        bOut.write(new IntPrimitive(this.ID).write());
        bOut.write(new IntPrimitive(this.value.size()).write());
        for(TlObject tlObject : this.value) {
            bOut.write(tlObject.write());
        }

        return bOut.toByteArray();
    }
}
