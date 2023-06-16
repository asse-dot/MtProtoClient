package telegram.connection.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract class TCP extends TransportProtocol {

    private String ip;
    private int port;

    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public TCP(String ip, int port) {

       this.ip = ip;
       this.port = port;

    }

    public void connect(){
        try {
            this.clientSocket = new Socket(this.ip, this.port);
            this.inputStream = this.clientSocket.getInputStream();
            this.outputStream = this.clientSocket.getOutputStream();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] read(int length) {
        byte[] data = new byte[length];
        int byte_read = 0;

        while(byte_read < length) {
            try {
                byte buffer[] = new byte[length - byte_read];
                int length_data = this.inputStream.read(buffer);
                System.arraycopy(buffer, 0, data, byte_read, length_data);
                byte_read += length_data;
            } catch(IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return data;
    }

    public void send(byte[] data) {

        try {
            this.outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {

        try {
            this.clientSocket.close();
            System.out.println("closed");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
