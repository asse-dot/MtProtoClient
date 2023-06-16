package telegram.raw.core.primitives;


import telegram.raw.core.TlObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class BytesPrimitive extends TlObject {

    private byte[] value;

    public BytesPrimitive(byte[] value) {
        this.value = value;
    }

    public byte[] getValue() {
        return value;
    }

    public static BytesPrimitive read(ByteArrayInputStream bytes) throws IOException {
        byte[] data;
        int length = bytes.read() & 0xff;

        if(length <= 253) {
            data = new byte[length];
            byte[] off_bytes = new byte[((length + 1) % 4) == 0 ? 0: (4- ((length + 1) % 4))];
            bytes.read(data);
            bytes.read(off_bytes);

        } else {
            byte[] length_bytes = new byte[3];
            bytes.read(length_bytes);
            length = (length_bytes[2] << 16) | (length_bytes[1] << 8) | length_bytes[0];

            data = new byte[length];
            byte[] off_bytes = new byte[(length % 4) == 0 ? 0: (4-length%4)];
            bytes.read(data);
            bytes.read(off_bytes);

        }

        return new BytesPrimitive(data);
    }

    //TODO test
    @Override
    public byte[] write(){
        int length = this.value.length;

        if(length <= 253) {
            int offset_bytes = ((length + 1) % 4) == 0 ? 0: (4- ((length + 1) % 4));
            byte[] data = new byte[length + 1 + offset_bytes];
            data[0] = (byte)length;
            System.arraycopy(this.value, 0, data, 1, length);
            System.arraycopy(new byte[offset_bytes], 0, data, length + 1, offset_bytes);
            return data;
        } else {
            int offset_bytes = (length % 4) == 0 ? 0: (4-(length%4));
            byte[] data = new byte[4 + length + offset_bytes];
            byte[] length_data = new byte[] {
                    (byte)(length),
                    (byte)(length >> 8),
                    (byte)(length >> 16),

            };

            data[0] = (byte) 0xfe;
            System.arraycopy(length_data, 0, data, 1, 3);
            System.arraycopy(this.value, 0, data, 4, length);
            System.arraycopy(new byte[offset_bytes], 0, data, length + 1, offset_bytes);
            return data;
        }

    }
}
