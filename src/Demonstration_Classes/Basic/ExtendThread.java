package Demonstration_Classes.Basic;

/**
 * Created by Matthew on 12/2/2015.
 */
public class ExtendThread extends Thread {

    public void run(){

        System.out.println("I'm a thread named " + Thread.currentThread().getName() + ". I extend Thread.");

    }

}
