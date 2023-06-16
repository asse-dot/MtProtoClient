import telegram.Client;
import telegram.Utils;
import telegram.crypto.Prime;
import telegram.crypto.RSA;
import telegram.session.MtProtoAuth;
import telegram.session.Session;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ClientTest {
    public static void main(String[] args) {


        //MtProtoAuth auth = new MtProtoAuth();
        Client client = new Client();

        client.start();
        client.idle();

        client.stop();

    }
}
