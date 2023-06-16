package telegram.connection.transport;

public abstract class TransportProtocol {

    public abstract void connect();
    public abstract void send(byte[] data);
    public abstract byte[] read();
    public abstract void close();

}
