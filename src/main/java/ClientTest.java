import telegram.Client;

import java.io.File;
//import telegram.TestListener;

public class ClientTest {
    public static void main(String[] args) {
       

        //MtProtoAuth auth = new MtProtoAuth();
        Client client = new Client(); //Initialize the client. This is the main instanceof.

        client.addListener(new TestListener(client)); //Add listener for handle update



        client.start(); //Init connection with a specific dc of telegram (Default: 2)ù
        client.sendMessage("started", 5402433797L);
        //client.sendPhoto(new File("statistica_correzione.jpg"), 5402433797L);
//        client.sendMessage("2", 5402433797L);
//        client.sendPhoto(new File("statistica_correzione.jpg"), 5402433797L);
        client.idle(); //Handle all update from telegram

        client.stop(); //stop connection
        //This is the case when the connection is stopped. Stop SessionWorker thread,
        //so, stop the connection and then all is close.


    }
}
