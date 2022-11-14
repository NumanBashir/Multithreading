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
        long durationOfItems = (long) (Math.random()*(6-1)+5);

        try {
            System.out.println(customer.getName() + ": Is waiting in line and is still shopping while waiting for his turn");
            sem.acquire();
            System.out.println(customer.getName() + ": Has the turn in the queue, place your groceries on the belt");
            //long durationOfItems = (long) (Math.random() * 1);
            TimeUnit.SECONDS.sleep(durationOfItems);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(customer.getName() + ": Has paid and now leaving the store | Left in: " + durationOfItems + " seconds" + "\n");
            sem.release();
        }
    }
}
