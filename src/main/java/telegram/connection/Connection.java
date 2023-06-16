package telegram.connection;

import telegram.connection.transport.TCPAbridged;
import telegram.connection.transport.TCPIntermediate;
import telegram.connection.transport.TransportProtocol;

public class Connection {

    private TransportProtocol protocol;

    public Connection(String type) {
        if(type.equals("TCP/0"))
            this.protocol = new TCPAbridged("149.154.167.91", 443);
        else if(type.equals("TCP/1"))
            this.protocol = new TCPIntermediate("149.154.167.91", 443);

    }

    public void connect() {
        this.protocol.connect();
    }

    public void send(byte[] data) {
        this.protocol.send(data);
    }

    public byte[] read() {
        return this.protocol.read();
    }

    public void close() {
        this.protocol.close();
    }


}
