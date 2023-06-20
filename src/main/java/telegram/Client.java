package telegram;

import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.functions.messages.SendMessage;
import telegram.raw.functions.updates.GetState;
import telegram.raw.functions.users.GetUsers;
import telegram.raw.types.*;
import telegram.session.Session;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client {

    private Session session;

    public Client() {
        File file = new File("bot.session");
        byte[] auth_key = new byte[256];
        if(file.exists()) {
            try {
                //RandomAccessFile files = new RandomAccessFile("s", "s");
                InputStream stream = new FileInputStream(file) ;
                stream.read(auth_key);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
//        Random random1 = new Random();
//        byte[] random = new byte[256];
//        random1.nextBytes(random);
//        System.out.println("finish");
//        try {
//            FileOutputStream stream = new FileOutputStream("/media/assedot/DEBIAN 11_3/bot1.session");
//            stream.write(random);
//
//            System.out.println("scritto");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        this.session = new Session(this, auth_key);



    }

    public TlObject invoke(TlObject data){
        return this.session.send(data);
    }

    public void start() {
        this.session.start();
        this.invoke(new GetState());
    }

    public void stop() {
        this.session.close();
    }

    public long getAccessHash(long peer_id) {

        if(!this.session.access_hash_by_peer.containsKey(peer_id)) {
            ArrayList<TlObject> inp = new ArrayList<>();
            inp.add(new InputUser(peer_id, 0));
            VectorPrimitive s = (VectorPrimitive) this.invoke(new GetUsers(inp));
            User user = (User) s.getValue().get(0);
            this.session.access_hash_by_peer.put(peer_id, user.access_hash);
        }

        return this.session.access_hash_by_peer.get(peer_id);

    }

    public void sendMessage(long id, String message) {
        this.invoke(new SendMessage(new InputPeerUser(id, this.getAccessHash(id)), message, this.session.getMessageId()));
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
        Message message_update = (Message)message.message;
        String string_message = message_update.message;
        if(message_update.entities != null) {
            TlObject ent = message_update.entities.get(0);
            Class<MessageEntityBold> clazz = MessageEntityBold.class;

            if (clazz.isInstance(ent)) {
                MessageEntityBold bold = (MessageEntityBold) ent;
                System.out.println("bold");
                System.out.println(bold.offset);
                System.out.println(bold.length);
            }
        }
        long id_user = user.id;

        Thread thread = new Thread(() -> this.test(id_user, string_message));
        thread.start();
    }


}
