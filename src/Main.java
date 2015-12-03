import Demonstration_Classes.Advanced.Deadlock;
import Demonstration_Classes.Basic.ImplementRunnable;
import Demonstration_Classes.Basic.ExtendThread;
import Demonstration_Classes.Intermediate.*;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Matthew on 12/2/2015.
 */
public class Main {

    public static void main(String[] args){

        Main main = new Main();
        main.run();

    }

    public void run(){

        threeTypes();

        System.out.println("Press 'Enter' to continue.");
        new Scanner(System.in).nextLine();

        volatileKeyword();

        System.out.println("Press 'Enter' to continue.");
        new Scanner(System.in).nextLine();

        synchronizedKeyword();

        System.out.println("Press 'Enter' to continue.");
        new Scanner(System.in).nextLine();

        lockObjects();

        System.out.println("Press 'Enter' to continue.");
        new Scanner(System.in).nextLine();

        threadPools();

        System.out.println("Press 'Enter' to continue.");
        new Scanner(System.in).nextLine();

        //These are the problem areas.

        //threadSafeObjects();

        //waitAndNotify();

        //deadlock();

        System.out.println("Press 'Enter' to continue.");
        new Scanner(System.in).nextLine();

        System.out.println("Special thanks to this site where I got and modified the code.");
        System.out.println("https://github.com/Beerkay/JavaMultiThreading/tree/master/JavaMultiThreadingCodes/src");
        System.out.println("Bye.");

    }

    public void threeTypes(){

        ExtendThread et = new ExtendThread();
        Thread ir = new Thread(new ImplementRunnable());
        Thread at = new Thread(new Runnable() {

            public void run() {

                System.out.println("I'm a thread named " + Thread.currentThread().getName() + ". I am Anonymous.");

            }

        });


        et.start();
        ir.start();
        at.start();

        try {

            et.join();
            ir.join();
            at.join();

        } catch (InterruptedException ignored) {}

    }

    public void volatileKeyword(){

        VolatileKeyword vk = new VolatileKeyword();
        vk.start();
        new Scanner(System.in).nextLine();
        vk.shutdown();

        try {
            vk.join();
        } catch (InterruptedException ignored) {}

    }

    public void synchronizedKeyword(){

        SynchronizedKeyword sk1 = new SynchronizedKeyword(false);
        sk1.start();

        try {

            sk1.join();

        } catch (InterruptedException ignored) {}

        SynchronizedKeyword sk2 = new SynchronizedKeyword(true);
        sk2.start();

    }

    public void lockObjects() {

        LockObject lo = new LockObject();
        lo.start();

    }

    public void threadPools() {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 100; i++) {

            executor.submit(new ThreadPool(i));

        }

        executor.shutdown();

        try {

            executor.awaitTermination(1, TimeUnit.DAYS);

        } catch (InterruptedException ignored) {}

    }

    public void threadSafeObjects() {

        ThreadSafeObject tso = new ThreadSafeObject();
        tso.start();

        try {

            tso.join();

        } catch (InterruptedException ignored) {}

    }

    public void waitAndNotify() {

        WaitAndNotify wan = new WaitAndNotify();
        wan.start();

    }

    public void deadlock() {

        Deadlock dl = new Deadlock();
        dl.start();

    }

}

