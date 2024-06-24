package learning.Threading;

import learning.Anagram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {
    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {

        /*CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Task(i, latch));
            if (i == 9) threadPool.shutdown();
        }
        latch.await();
        if (threadPool.isTerminated())*/

        Task t = new Task(1);
        Task t1 = new Task(5);
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t1).start();
        System.out.println("Ended");


    }
}

class Task implements Runnable {


    private volatile int a = 0;

    public Task(int i) {
        this.a = i;
    }

    @Override
    public void run() {

        try {
            synchronized (this) {
                if (a == 8)
                    System.out.println(1 / 0);

                if (a == 5) {
                    System.out.println(Anagram.countCharacters("kaaaaaaaaaaw"));
                }
                System.out.println("Thread " + a + " " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}