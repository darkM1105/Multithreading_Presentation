package Demonstration_Classes.Intermediate;

import java.util.Scanner;

/**
 * Created by Matthew on 12/2/2015.
 */
public class WaitAndNotify extends Thread{

    public void run(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();

        try{

            t1.join();
            t2.join();

        }catch(InterruptedException ignored){}

    }

    public void produce() throws InterruptedException {

        synchronized (this) {

            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Resumed.");

        }

    }

    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {

            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
            System.out.println("Consumption done.");

        }

    }

}
