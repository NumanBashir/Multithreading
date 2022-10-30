import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        boolean run = true;
        Semaphore sem = new Semaphore(1);

        MyThread thread1 = new MyThread(sem, run);
        MyThread thread2 = new MyThread(sem, run);

        thread1.start();
        thread2.start();

    }

}
