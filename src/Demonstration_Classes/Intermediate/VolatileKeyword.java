package Demonstration_Classes.Intermediate;

/**
 * Created by Matthew on 12/2/2015.
 */
public class VolatileKeyword extends Thread{

    private volatile boolean running = true;
    private int count = 1;

    public void run(){

        while(running){

            System.out.println("Press 'Enter' to stop.");

            for(int i = 1; i <= 1000; i++){

                System.out.println(Thread.currentThread().getName() + " says the count is " + count);
                count++;

                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {}

            }

        }

    }

    public void shutdown() {

        running = false;

    }

}
