package telegram.connection.transport;

public class TCPIntermediate extends TCP{

    private static final byte[] initialize = new byte[] {(byte)0xee, (byte)0xee, (byte)0xee, (byte)0xee};

    public TCPIntermediate(String ip, int port) {
        super(ip, port);
    }

    @Override
    public void connect() {
        super.connect();
        super.send(initialize);
    }
    
    @Override
    public void send(byte[] data) {
        int length = data.length;
        byte[] length_byte =  new byte[]{
                (byte) (length),
                (byte) (length >> 8),
                (byte) (length >> 16),
                (byte) (length >> 24)
        };

        byte[] buffer = new byte[length + 4];
        System.arraycopy(length_byte, 0, buffer, 0, 4);
        System.arraycopy(data, 0, buffer, 4, length);

        super.send(buffer);

    } 

    @Override
    public byte[] read() {
        byte[] length_byte = super.read(4);
        int length = ((length_byte[3] & 0xFF) << 24) | ((length_byte[2] & 0xFF) << 16) | ((length_byte[1] & 0xFF) << 8) | (length_byte[0] & 0xFF);

        return super.read(length);
    }
}
