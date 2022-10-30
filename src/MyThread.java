import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    Semaphore sem;
    private boolean run = true;
    Scanner scan = new Scanner(System.in);

    public MyThread(Semaphore sem, boolean run) {
        this.sem = sem;
        this.run = run;
    }

    public void run() {

        while(run) {
            scan.next();
            System.out.println("Music is playing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*for(int i = 0; i < 5; i++) {
            System.out.println(i + " from thread " + threadNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

}
