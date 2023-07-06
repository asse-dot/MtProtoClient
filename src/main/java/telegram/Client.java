package telegram;

import telegram.listeners.Listener;
import telegram.listeners.MessageEventUpdate;
import telegram.listeners.MessageListener;
import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.functions.messages.SendMedia;
import telegram.raw.functions.messages.SendMessage;
import telegram.raw.functions.updates.GetState;
import telegram.raw.functions.upload.SaveBigFilePart;
import telegram.raw.functions.upload.SaveFilePart;
import telegram.raw.functions.users.GetUsers;
import telegram.raw.types.*;
import telegram.session.MtProtoAuth;
import telegram.session.Session;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private Session session;
    private List<Listener> listeners;
    private ExecutorService executorService;
    private byte[] auth_key;

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
        //RandomAccessFile files = new RandomAccessFile("s", "s");
        if(file.exists()) {
            System.out.println("Il bro esiste");
            try(InputStream stream = new FileInputStream(file)){
                stream.read(auth_key);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                file.createNewFile();
                System.out.println("created file");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Il bro NON esiste");
            try(OutputStream stream = new FileOutputStream(file)) {
                MtProtoAuth auth = new MtProtoAuth();
                auth_key = auth.createAuthKey();
                System.out.println("created");
                stream.write(auth_key);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        //auth_key = new byte[] {-79, -5, -44, 48, 17, 65, -54, 82, -110, 15, -18, 66, -45, -58, 92, -50, -125, -16, -71, 99, 43, -106, -1, 116, -90, -24, 19, -112, 21, 84, 86, -21, 121, -79, -3, 112, -26, -30, 103, 116, -17, 124, -53, -39, -91, 13, 60, -74, 67, 92, -125, 27, 92, 6, 9, -124, 81, 77, 98, 24, -103, 60, 44, -85, 65, -61, 34, 22, -73, 121, -94, 102, -21, 115, 75, 64, 26, -25, 43, 24, 114, 60, -25, -82, -18, 101, -73, 17, -79, -61, 7, -52, -2, -78, -117, -33, -83, 117, -12, 115, 72, 24, -11, -57, -9, -4, 55, -49, 28, -107, -42, -84, 38, 55, 41, 66, -3, -117, -92, 118, 83, 48, 51, -78, -26, -122, 91, 10, 66, 32, 96, -69, 127, -44, -83, 60, 9, 20, -100, -93, -48, -29, -91, -64, -99, -121, -66, -31, -117, -69, -18, 88, 106, 70, 53, -120, 14, 46, 38, 28, 102, -117, 14, -94, -55, 15, 6, 22, 92, 117, 15, 105, 26, 7, 26, 61, 42, 29, 32, 63, -26, 97, 87, -105, 28, 79, -49, 95, 11, 75, -63, -98, -13, -25, -126, -53, 120, -101, -107, 20, 7, -17, -3, 54, 61, 93, 113, 20, -110, -94, -70, -4, -30, 100, -72, 88, -33, -92, 78, -68, -43, 25, 64, 31, 11, -8, 52, 126, 76, -33, 45, -103, 122, 30, 4, -1, -4, 93, 107, 11, -93, -125, -99, 83, -5, 60, -114, 49, -122, 76, -5, 13, 126, -82, -61, -47};
        //System.out.println(Arrays.toString(auth_key));
        this.auth_key = auth_key;
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

//    public void sendMessage(long id, String message) {
//        this.invoke(new SendMessage(new InputPeerUser(id, this.getAccessHash(id)), message, this.session.getMessageId()));
//    }


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
        for (Listener listener : this.listeners) {

            if (listenerType.isInstance(listener)) {
                try {
                    Object parsedUpdate = parsedUpdateType.getMethod("parse", TlObject.class, List.class).invoke(null, update, users);

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

    public void sendMessage(String message, long id) {
        this.invoke(new SendMessage(
                false,
                false,
                false,
                false,
                false,
                false,
                new InputPeerUser(id, this.getAccessHash(id)),
                0,
                0,
                message,
                this.session.getMessageId(),
                null,
                null,
                0,
                null
        ));

    }

    public void sendPhoto(String filePath, long id) {
        Path path = Paths.get(filePath);
        try {
            this.sendPhoto(path.getFileName().toString(), new FileInputStream(path.toFile()), id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendPhoto(Path path, long id) {
        try {
            this.sendPhoto(path.getFileName().toString(), new FileInputStream(path.toFile()), id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendPhoto(File file, long id) {
        try {
            this.sendPhoto(file.getName(), new FileInputStream(file), id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendPhoto(String name, InputStream photo, long id) {
        try {
            TlObject file = this.saveFile(name, photo);
            InputMediaUploadedPhoto media = new InputMediaUploadedPhoto(false, file, null, 0);

            this.invoke(new SendMedia(
                    false,
                    false,
                    false,
                    false,
                    false,
                    new InputPeerUser(id, this.getAccessHash(id)),
                    0,
                    0,
                    media,
                    "",
                    this.session.getMessageId(),
                    null,
                    null,
                    0,
                    null
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public TlObject saveFile(String name, InputStream stream) throws IOException {
        long file_id = this.session.getMessageId();
        int part_size =  512 * 1024;
        int file_size = stream.available();

        int total_parts = (int)Math.ceil(file_size / part_size);
        boolean is_big =  file_size > 10 * 1024 * 1024;

        Session session = new Session(this, this.auth_key);
        session.start();

        int file_part = 0;
        while(true) {
            TlObject rpc;
            byte[] chunk = new byte[part_size];
            int end = stream.read(chunk);
            if(end == -1)
                break;

            if(is_big) {
                rpc = new SaveBigFilePart(file_id, file_part, total_parts, chunk);
            } else {
                rpc = new SaveFilePart(file_id, file_part, chunk);
            }

            session.send(rpc);
            file_part += 1;
        }
        session.close();
        if(is_big) {
            return new InputFileBig(file_id, total_parts, name);
        }  else{
            return new InputFile(file_id, total_parts, name, "");
        }

    }


}
