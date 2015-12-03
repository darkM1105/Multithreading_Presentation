package Demonstration_Classes.Basic;

/**
 * Created by Matthew on 12/2/2015.
 */
public class ImplementRunnable implements Runnable {

    public void run(){

        System.out.println("I'm a thread named " + Thread.currentThread().getName() + ". I implement Runnable");

    }

}
