package com.Threading;

import com.Anargam;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {
    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Task(i, latch));
            if (i == 9) threadPool.shutdown();
        }
        latch.await();
        if (threadPool.isTerminated())
        System.out.println("Ended");


    }
}

class Task implements Runnable {

    CountDownLatch latch;
    private volatile int a = 0;

    public Task(int i, CountDownLatch latch) {
        this.a = i;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            if (a == 8)
                System.out.println(1 / 0);
            Anargam anargam = new Anargam();
            if (a == 5) {
                System.out.println(Anargam.countCharacters("kaaaaaaaaaa"));
            }
            System.out.println("Thread " + a + " " + Thread.currentThread().getName());
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}