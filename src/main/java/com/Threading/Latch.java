package com.Threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Latch {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 6; i++) {
            service.submit(new Task1(latch));
        }

        latch.await();
        System.out.println("Main Function ends");
        service.shutdown();
    }
}

class Task1 implements Runnable {

    CountDownLatch latch;

    public Task1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread has reached");
        latch.countDown();
        System.out.println("Thread has ended");
    }
}