package telegram.session;

import telegram.Client;
import telegram.Utils;
import telegram.connection.Connection;
import telegram.crypto.MtProto;
import telegram.raw.core.Message;
import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.VectorPrimitive;
import telegram.raw.core.primitives.integers.LongPrimitive;
import telegram.raw.functions.InitConnection;
import telegram.raw.functions.InvokeWithLayer;
import telegram.raw.functions.auth.ImportBotAuthorization;
import telegram.raw.functions.help.GetConfig;
import telegram.raw.functions.messages.SendMessage;
import telegram.raw.functions.updates.GetState;
import telegram.raw.functions.users.GetUsers;
import telegram.raw.types.BadServerSalt;
import telegram.raw.types.InputPeerUser;
import telegram.raw.types.InputUser;
import telegram.raw.types.User;

import java.beans.IndexedPropertyChangeEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Session {

    public Connection connection;
    public Client client;
    private long salt;
    private int seq_no;
    private byte[] session_id;
    private byte[] auth_key_id;
    private byte[] auth_key;

    private long last_time;
    private long offsetId;

    private SessionWorker sessionWorker;
    private Thread threadWorker;

    private HashMap<Long, EventUpdates<TlObject>> results;

    public Session(Client client, byte[] auth_key){
        Random random = new Random();
        MessageDigest sha1;
        try {
            sha1 = MessageDigest.getInstance("SHA-1");
        } catch(NoSuchAlgorithmException e) {
            return;
        }
        this.connection = new Connection("TCP/1");
        this.client = client;
        this.auth_key = auth_key;
        this.salt = 0;
        this.seq_no = 0;
        this.session_id = new byte[8];
        random.nextBytes(session_id);
        this.auth_key_id = Utils.subStr(sha1.digest(auth_key), 12, 8);
        this.results = new HashMap<>();
        this.sessionWorker = new SessionWorker(this.client, this.connection, this.auth_key, this.results);
        this.threadWorker = new Thread(this.sessionWorker);

        this.last_time = (System.currentTimeMillis() / 1000L);
        this.offsetId = 0;
    }

    public long getMessageId() {
        long time = (System.currentTimeMillis() / 1000L);
        this.offsetId = this.last_time == time ? (offsetId + 4) : 0;
        long messageId = time * (long)Math.pow(2, 32) + this.offsetId;
        this.last_time = time;

        return messageId;
    }

    public void start() throws IOException {
        this.connection.connect();
        this.threadWorker.start();
        this.send(
                new InvokeWithLayer(158, new InitConnection(
                        13776999,
                        "Linux",
                        "1.8.8",
                        "1.8",
                        "en",
                        "",
                        "en",
                        new GetConfig()
                ))
        );

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        this.send(
//                new ImportBotAuthorization(
//                    0, 13776999, "b6582ebcf826855345ce1155e8d42522", "6210228531:AAHoxXDFzt_J64xMfYAnQUHQWXv8_Atuw3w"
//                ), 3
//        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ArrayList<TlObject> inp = new ArrayList<>();
//        inp.add(new InputUser(5690391779L, 0));
//        VectorPrimitive s = (VectorPrimitive) this.send(new GetUsers(inp), 3);
//        User user = (User) s.getValue().get(0);
//        System.out.println(user.first_name);
//        System.out.println(user.id);
//        System.out.println(user.access_hash);
        //long access_hash = 1101110740135180657L;
        //this.send(new SendMessage(new InputPeerUser(5690391779L, access_hash), "Randominator", this.getMessageId()));

    }

    public void close() {
        this.sessionWorker.stopRunning();
        try {
            this.send(new GetState());
            this.threadWorker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.connection.close();
    }

    public TlObject send(TlObject data) throws IOException {
        long message_id = this.getMessageId();
        Message message = new Message(data, message_id, (this.seq_no * 2) + 1, data.getLength());
        byte[] payload = MtProto.pack(message, this.salt, this.session_id, this.auth_key_id, this.auth_key);

        this.results.put(message_id, new EventUpdates<>());
        this.connection.send(payload);

        this.seq_no += 1;

        this.results.get(message_id).waitObject();

        TlObject result =  this.results.remove(message_id).getValue();

        if(result instanceof BadServerSalt) {
            this.salt = ((BadServerSalt)result).new_server_salt;
        }

        return result;
    }





}
