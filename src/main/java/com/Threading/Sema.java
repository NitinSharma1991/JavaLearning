package com.Threading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Sema {

    public static void main(String[] args) {
        List webDriverList;
        ExecutorService service = Executors.newFixedThreadPool(4);
        Semaphore semaphore = new Semaphore(2);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            service.execute(new SemaRun(semaphore, atomicInteger));
        }
        service.shutdown();
    }
}

class SemaRun implements Runnable {

    Semaphore sem;
    AtomicInteger atomicInteger;

    public SemaRun(Semaphore sem, AtomicInteger atomicInteger) {
        this.sem = sem;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        System.out.println("Thread " + atomicInteger.incrementAndGet());
        sem.acquireUninterruptibly();
        System.out.println("Thread Name " + Thread.currentThread().getId());
        sem.release();

    }
}