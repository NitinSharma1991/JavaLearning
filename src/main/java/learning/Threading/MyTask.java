package learning.Threading;

public class MyTask implements Runnable {


    @Override
    public void run() {
        System.out.println("I am here");
//        Thread.interrupted();
    }
}
