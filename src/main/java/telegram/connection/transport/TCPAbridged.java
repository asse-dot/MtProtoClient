package telegram.connection.transport;

public class TCPAbridged extends TCP {

    private static final byte[] initialize = new byte[] {(byte)0xef};

    public TCPAbridged(String ip, int port) {
        super(ip, port);
    }

    @Override
    public void connect() {
        super.connect();
        super.send(initialize);
    }

    @Override
    public void send(byte[] data) {

        int length = data.length / 4;

        byte[] buffer;
        if (length <= 126) {
             buffer = new byte[data.length + 1];
             buffer[0] = (byte)length;
             System.arraycopy(data, 0, buffer, 1, data.length);
        } else {
            buffer = new byte[data.length + 4];
            byte[] length_data = new byte[] {
                    (byte)(length),
                    (byte)(length >> 8),
                    (byte)(length >> 16),

            };
            buffer[0] = (byte)0x7f;
            System.arraycopy(length_data, 0, buffer, 1, 3);
            System.arraycopy(data, 0, buffer, 4, data.length);
        }
        super.send(buffer);

    }


    public byte[] read() {
        int length;

        byte temp = super.read(1)[0];

        if(temp == 0x7f) {
            byte[] byte_length = super.read(3);
            length = ((byte_length[2] & 0xFF) << 16) | ((byte_length[1] & 0xFF) << 8) | (byte_length[0] & 0xFF);
        } else {
            length = temp;
        }

        return super.read(length * 4);
    }



}
