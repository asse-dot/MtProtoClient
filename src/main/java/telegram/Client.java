package telegram;

import telegram.listeners.Listener;
import telegram.listeners.MessageEventUpdate;
import telegram.listeners.MessageListener;
import telegram.listeners.ParsedUpdate;
import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.functions.messages.SendMessage;
import telegram.raw.functions.updates.GetState;
import telegram.raw.functions.users.GetUsers;
import telegram.raw.types.*;
import telegram.session.Session;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private Session session;
    private List<Listener> listeners;
    private ExecutorService executorService;

    private static Map<Class<? extends TlObject>, List<Class<?>>>  map = new HashMap<>();
    private static List<Class<?>> messages = new ArrayList<>();

    static {
        messages.add(MessageListener.class);
        messages.add(MessageEventUpdate.class);
        map.put(UpdateNewMessage.class, messages);
    }

    public Client() {
        this.listeners = new LinkedList<>();
        this.executorService = Executors.newFixedThreadPool(10);
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

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    private void notifyUpdate(TlObject update, List<TlObject> users) {
        Class listenerType = map.get(update.getClass()).get(0);
        Class parsedUpdateType = map.get(update.getClass()).get(1);
        for(Listener listener : this.listeners) {

            if(listenerType.isInstance(listener)) {
                try {
                    ParsedUpdate parsedUpdate = (ParsedUpdate) parsedUpdateType.getMethod("parse", TlObject.class, List.class).invoke(null, update, users);

                    Method task = listenerType.getMethod("invoke", parsedUpdateType);
                    this.executorService.submit(() -> task.invoke(listener, parsedUpdateType.cast(parsedUpdate)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

            }
        }

    }


    public void handleUpdate(Updates updates) {
        TlObject update = updates.updates.get(0);
        List<TlObject> users = updates.users;

        this.notifyUpdate(update, users);
    }


}
