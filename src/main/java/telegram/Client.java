package telegram;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.functions.messages.SendMessage;
import telegram.raw.functions.updates.GetState;
import telegram.raw.functions.users.GetUsers;
import telegram.raw.types.*;
import telegram.session.Session;

import java.io.IOException;
import java.util.ArrayList;

public class Client {

    private Session session;

    public Client() {
        byte[] auth_key = new byte[] {-79, -5, -44, 48, 17, 65, -54, 82, -110, 15, -18, 66, -45, -58, 92, -50, -125, -16, -71, 99, 43, -106, -1, 116, -90, -24, 19, -112, 21, 84, 86, -21, 121, -79, -3, 112, -26, -30, 103, 116, -17, 124, -53, -39, -91, 13, 60, -74, 67, 92, -125, 27, 92, 6, 9, -124, 81, 77, 98, 24, -103, 60, 44, -85, 65, -61, 34, 22, -73, 121, -94, 102, -21, 115, 75, 64, 26, -25, 43, 24, 114, 60, -25, -82, -18, 101, -73, 17, -79, -61, 7, -52, -2, -78, -117, -33, -83, 117, -12, 115, 72, 24, -11, -57, -9, -4, 55, -49, 28, -107, -42, -84, 38, 55, 41, 66, -3, -117, -92, 118, 83, 48, 51, -78, -26, -122, 91, 10, 66, 32, 96, -69, 127, -44, -83, 60, 9, 20, -100, -93, -48, -29, -91, -64, -99, -121, -66, -31, -117, -69, -18, 88, 106, 70, 53, -120, 14, 46, 38, 28, 102, -117, 14, -94, -55, 15, 6, 22, 92, 117, 15, 105, 26, 7, 26, 61, 42, 29, 32, 63, -26, 97, 87, -105, 28, 79, -49, 95, 11, 75, -63, -98, -13, -25, -126, -53, 120, -101, -107, 20, 7, -17, -3, 54, 61, 93, 113, 20, -110, -94, -70, -4, -30, 100, -72, 88, -33, -92, 78, -68, -43, 25, 64, 31, 11, -8, 52, 126, 76, -33, 45, -103, 122, 30, 4, -1, -4, 93, 107, 11, -93, -125, -99, 83, -5, 60, -114, 49, -122, 76, -5, 13, 126, -82, -61, -47};
        this.session = new Session(this, auth_key);
    }

    public TlObject invoke(TlObject data) throws IOException {
        return this.session.send(data);
    }

    public void start() {
        try {
            this.session.start();
            this.invoke(new GetState());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.session.close();
    }

    public long getAccessHash(long peer_id) {
        try {
            ArrayList<TlObject> inp = new ArrayList<>();
            inp.add(new InputUser(peer_id, 0));
            VectorPrimitive s = (VectorPrimitive) this.invoke(new GetUsers(inp));
            User user = (User) s.getValue().get(0);
            return user.access_hash;
        }catch(IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void sendMessage(long id, String message) {
        try {
            this.invoke(new SendMessage(new InputPeerUser(id, this.getAccessHash(id)), message, this.session.getMessageId()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test(long id, String message) {
        System.out.println(id);
        System.out.println(message);
        this.sendMessage(id, message);
    }

    public void idle() {
        while(true) {

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void handleUpdate(Updates update) {
        UpdateNewMessage message = ((UpdateNewMessage)update.updates.get(0));
        User user = ((User)update.users.get(0));
        String string_message = ((Message)message.message).message;
        long id_user = user.id;
        Thread thread = new Thread(() -> this.test(id_user, string_message));
        thread.start();
    }


}
