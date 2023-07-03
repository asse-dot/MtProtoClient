import telegram.Client;
import telegram.TestListener;

public class ClientTest {
    public static void main(String[] args) {
       

        //MtProtoAuth auth = new MtProtoAuth();
        Client client = new Client(); //Initialize the client. This is the main instanceof.

        client.addListener(new TestListener(client)); //Add listener for handle update

        client.start(); //Init connection with a specific dc of telegram (Default: 2)

        client.idle(); //Handle all update from telegram

        client.stop(); //stop connection
        //This is the case when the connection is stopped. Stop SessionWorker thread,
        //so, stop the connection and then all is close.


    }
}
