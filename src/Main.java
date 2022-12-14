import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        QueueThread queueThread = new QueueThread();
        int customersWaitingInLine = 5;
        int customersPaying = 2;

        Thread box1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int customerCount = 0;
                while (customerCount < customersPaying) {
                    Customer customer = new Customer(queueThread);
                    Thread thread1 = new Thread(customer);
                    customer.setName("Customer " + thread1.getId());
                    thread1.start();
                    customerCount++;
                    System.out.println("In box: " + Thread.currentThread().getName());

                    try {
                        Thread.sleep((long) (Math.random()*(10-1)+1));
                        //Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread box2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int customerCount = 0;
                while (customerCount < customersPaying) {
                    Customer customer = new Customer(queueThread);
                    Thread thread1 = new Thread(customer);
                    customer.setName("Customer " + thread1.getId());
                    thread1.start();
                    customerCount++;
                    System.out.println("In box: " + Thread.currentThread().getName());

                    try {
                        Thread.sleep((long) (Math.random()*(10-1)+1));
                        //Thread.sleep(10000);
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
                    customer.setName("Customer " + thread1.getId());
                    thread1.start();
                    customerCount++;

                    try {
                        Thread.sleep((long) (Math.random()*(10-1)+1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        box1.start();
        box2.start();
        inLine.start();

    }

}
