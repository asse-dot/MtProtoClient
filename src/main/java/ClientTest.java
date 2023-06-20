import telegram.Client;

public class ClientTest {
    public static void main(String[] args) {
       

        //MtProtoAuth auth = new MtProtoAuth();
        Client client = new Client();
        client.start();
        client.idle();
        client.stop();

    }
}
