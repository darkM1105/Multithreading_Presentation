package Demonstration_Classes.Intermediate;

/**
 * Created by Matthew on 12/2/2015.
 */
public class SynchronizedKeyword extends Thread{

    private boolean isSynchronized;
    private int count = 1;
    private volatile int verifiedCount = 0;
    private volatile boolean canRun = true;

    public SynchronizedKeyword(boolean isSynchronized){
        this.isSynchronized = isSynchronized;
    }

    public void run(){

        Thread t1 = new Thread(new Runnable() {

            public void run() {

                for(int i = 0; i < 100; i++){

                    if(canRun){

                        System.out.println(Thread.currentThread().getName() + " thinks the count is currently " + count);
                        canRun = verify(count);

                        try {

                            Thread.sleep(10);

                        } catch (InterruptedException ignored) {}

                        increment();

                    } else {

                        System.out.print("Bye ");

                    }

                }

            }

        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {

                for(int i = 0; i < 100; i++){

                    if(canRun){

                        System.out.println(Thread.currentThread().getName() + " thinks the count is currently " + count);
                        canRun = verify(count);

                        try {

                            Thread.sleep(10);

                        } catch (InterruptedException ignored) {}

                        increment();

                    } else {

                        System.out.print("Bye ");

                    }

                }

            }

        });

        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();

        } catch (InterruptedException ignored) {}

    }

    public boolean verify(int count){

        if(count == verifiedCount){

            System.out.println("Someone is misinformed about the count.");
            return false;

        } else {

            return true;

        }

    }

    public void increment() {

        if(isSynchronized) {

            synchronizedIncrement();

        } else {

            normalIncrement();

        }

    }

    public synchronized void synchronizedIncrement() {

        verifiedCount = count;
        count++;

    }

    public void normalIncrement() {

        verifiedCount = count;
        count++;

    }

}
