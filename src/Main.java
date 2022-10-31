import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        QueueThread queueThread = new QueueThread();
        int customersWaitingInLine = 5;
        int customersPaying = 1;

        Thread paying = new Thread(new Runnable() {
            @Override
            public void run() {
                int customerCount = 0;
                while (customerCount < customersPaying) {
                    Customer customer = new Customer(queueThread);
                    Thread thread1 = new Thread(customer);
                    customer.setName("" + thread1.getId());
                    thread1.start();
                    customerCount++;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread inLine = new Thread(new Runnable() {
            @Override
            public void run() {
                int customerCount = 0;
                while (customersWaitingInLine > customerCount) {
                    Customer customer = new Customer(queueThread);
                    Thread thread1 = new Thread(customer);
                    customer.setName("" + thread1.getId());
                    thread1.start();
                    customerCount++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        paying.start();
        inLine.start();

    }

}
