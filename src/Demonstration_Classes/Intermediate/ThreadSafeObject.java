package Demonstration_Classes.Intermediate;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Matthew on 12/2/2015.
 */
@SuppressWarnings("InfiniteLoopStatement")
public class ThreadSafeObject extends Thread{

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    private boolean canRun = true;

    public void run(){

        Thread t1 = new Thread(new Runnable() {

            public void run() {

                try {

                    producer();

                } catch (InterruptedException ignored) {}

            }

        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {

                try {

                    consumer();

                } catch (InterruptedException ignored) {}

            }

        });

        t1.start();
        t2.start();

        try {

            Thread.sleep(10000);

        } catch (InterruptedException ignored) {}

        canRun = false;

    }

    private void producer() throws InterruptedException {

        Random random = new Random();

        while (canRun) {

            queue.put(random.nextInt(100));

        }

    }

    private void consumer() throws InterruptedException {

        Random random = new Random();

        while (canRun) {

            Thread.sleep(100);

            if (random.nextInt(10) == 0) {

                Integer value = queue.take();
                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());

            }

        }

        System.out.println("Consumer Done.");

    }

}