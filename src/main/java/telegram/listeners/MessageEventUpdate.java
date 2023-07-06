package telegram.listeners;

import telegram.raw.core.TlObject;
import telegram.raw.types.Message;
import telegram.raw.types.UpdateNewMessage;
import telegram.raw.types.User;

import java.util.List;

public class MessageEventUpdate{

    private String message;
    private long chat_id;

    public MessageEventUpdate(String message, long chat_id) {
        this.message = message;
        this.chat_id = chat_id;
    }

    public String getMessage() {
        return message;
    }

    public long getChat_id() {
        return chat_id;
    }

    public static MessageEventUpdate parse(TlObject update, List<TlObject> users) {
        UpdateNewMessage updateNewMessage = (UpdateNewMessage) update;
        Message message = (Message) updateNewMessage.message;

        User user = (User)users.get(0);

        return new MessageEventUpdate(message.message, user.id);


    }
}
