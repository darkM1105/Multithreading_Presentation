package Demonstration_Classes.Intermediate;

/**
 * Created by Matthew on 12/2/2015.
 */
public class ThreadPool extends Thread{

    private int task;

    public ThreadPool(int task) {

        this.task = task;

    }

    public void run(){

        System.out.println(Thread.currentThread().getName() + " is doing task number " + task);

    }

}
