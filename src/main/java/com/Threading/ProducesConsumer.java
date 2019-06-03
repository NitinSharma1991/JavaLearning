package com.Threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducesConsumer {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new LinkedBlockingQueue();

        Thread t1 = new Thread(new Producer(blockingQueue));
        Thread t2 = new Thread(new Consumer(blockingQueue));

        t1.start();
        t2.start();
    }
}
