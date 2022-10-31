import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class QueueThread extends Thread {

    Semaphore sem;

    public QueueThread() {
        sem = new Semaphore(1);
    }


    public void buyGrocerciesInLine(Customer customer) {
        try {
            System.out.println(customer.getName() + " is waiting in line");
            sem.acquire();
            System.out.println(customer.getName() + " has the turn in the queue, place your groceries on the belt");
            long durationOfItems = (long) (Math.random() * 1);
            TimeUnit.SECONDS.sleep(durationOfItems);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(customer.getName() + " has paid and now leaving the store");
            sem.release();
        }
    }
}
