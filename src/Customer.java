public class Customer implements Runnable {

    private String name;
    private QueueThread queueThread;

    public Customer(QueueThread queueThread) {
        this.queueThread = queueThread;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        queueThread.buyGrocerciesInLine(this);
    }

}
