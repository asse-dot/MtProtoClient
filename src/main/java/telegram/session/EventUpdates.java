package telegram.session;

public class EventUpdates<T> {

    private Object object;
    private boolean wasSignalled;

    private T value;

    public EventUpdates() {
        this.object = new Object();
        this.wasSignalled = false;
    }

    public void set() {
        synchronized(this.object) {
            this.object.notify();
            this.wasSignalled = true;
        }
    }

    public void waitObject() {
        synchronized(this.object) {
            while(!this.wasSignalled) {
                try {
                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
