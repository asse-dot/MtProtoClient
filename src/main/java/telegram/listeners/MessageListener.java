package telegram.listeners;

public interface MessageListener extends Listener {

    void invoke(MessageEventUpdate e);

}
