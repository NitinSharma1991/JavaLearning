package learning.Threading;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Sema {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(4);
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 10; i++) {
//            service.execute(new SemaRun(semaphore, i));
            Thread.startVirtualThread(new SemaRun(semaphore, i));
        }

        Thread.startVirtualThread(() -> System.out.println("I am Virtual Thread"));
        Thread.sleep(1000);
        service.shutdown();
    }
}

class SemaRun implements Runnable {

    Semaphore sem;
    int atomicInteger;

    public SemaRun(Semaphore sem, int atomicInteger) {
        this.sem = sem;
        this.atomicInteger = atomicInteger;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Thread " + atomicInteger);
        sem.acquireUninterruptibly();

        System.out.println("Thread Name " + Thread.currentThread() + " " + atomicInteger);
        sem.release();

    }
}