package Demonstration_Classes.Intermediate;

import java.util.Random;

/**
 * Created by Matthew on 12/2/2015.
 */
public class LockObject extends Thread{

    private Random random = new Random();
    private int count = 1;
    private final Object lock = new Object();

    public void run(){

        Thread t1 = new Thread(new Runnable() {

            public void run() {

                for(int i = 0; i < 500; i++){

                    doStuff();

                }

            }

        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {

                for(int i = 0; i < 500; i++){

                    doStuff();

                }

            }

        });

        t1.start();
        t2.start();

    }

    public void doStuff() {

        try {

            Thread.sleep(random.nextInt(10));
            System.out.println(Thread.currentThread().getName() + " slept for a while.");

        } catch (InterruptedException ignored) {}

        synchronized (lock) {

            System.out.println(Thread.currentThread().getName() + " says the count is " + count);
            count++;

        }

    }

}
