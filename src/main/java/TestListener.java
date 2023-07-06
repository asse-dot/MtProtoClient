import telegram.Client;
import telegram.listeners.Listener;
import telegram.listeners.MessageEventUpdate;
import telegram.listeners.MessageListener;

public class TestListener implements MessageListener {

    private Client client;

    public TestListener(Client client) {

        this.client = client;

    }

    @Override
    public void invoke(MessageEventUpdate e) {
        this.client.sendMessage(String.valueOf(e.getChat_id()), e.getChat_id());
        System.out.println(e.getChat_id());
    }
}
