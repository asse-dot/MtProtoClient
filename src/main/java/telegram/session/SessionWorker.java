package telegram.session;

import telegram.Client;
import telegram.connection.Connection;
import telegram.crypto.MtProto;
import telegram.raw.core.Message;
import telegram.raw.core.TlObject;
import telegram.raw.core.primitives.StringPrimitive;
import telegram.raw.core.primitives.integers.IntPrimitive;
import telegram.raw.types.BadServerSalt;
import telegram.raw.types.RpcResult;
import telegram.raw.types.UpdateNewMessage;
import telegram.raw.types.Updates;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.HashMap;

public class SessionWorker implements Runnable{

    private Connection connection;
    private Client client;
    private byte[] auth_key;

    private HashMap<Long, EventUpdates<TlObject>> results;

    private boolean running;

    public SessionWorker(Client client, Connection connection, byte[] auth_key, HashMap<Long, EventUpdates<TlObject>> results) {
        this.client = client;
        this.connection = connection;
        this.auth_key = auth_key;
        this.results = results;
        this.running = true;
    }


    private void handlePacket(byte[] packet) {

        Message data;
        try {
            data = MtProto.unpack(packet, this.auth_key);
        }catch(IOException e) {
            e.printStackTrace();
            return;
        }

        long msg_id = 0;
        TlObject value = data.body;
        if(data.body instanceof BadServerSalt) {
            msg_id = ((BadServerSalt) data.body).bad_msg_id;
        } else if(data.body instanceof RpcResult) {
            msg_id = ((RpcResult) data.body).req_msg_id;
            value = ((RpcResult) data.body).result;
        } else if(data.body instanceof Updates) {
            this.client.handleUpdate((Updates)data.body);
        }


        if(this.results.containsKey(msg_id)) {
            this.results.get(msg_id).setValue(value);
            this.results.get(msg_id).set();
        }

    }

    public void stopRunning() {
        this.running = false;
    }


    @Override
    public void run() {
        while(this.running) {

            byte[] data = this.connection.read();
            if(data == null)
                continue;

            if(data.length == 4) {
                try {
                    int error_code = IntPrimitive.read(new ByteArrayInputStream(data)).getValue();
                    System.out.println("Error code: " + error_code);
                    for(Long event : this.results.keySet()) {
                        this.results.get(event).set();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //TODO handle all errors
                continue;
            }

            handlePacket(data);
        }
    }
}
