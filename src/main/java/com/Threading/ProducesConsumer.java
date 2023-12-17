package com.Threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducesConsumer {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        Thread t1 = new Thread(new Producer(blockingQueue));
        Thread t2 = new Thread(new Consumer(blockingQueue));
        t1.start();
//        t3.start();
//        t4.start();
        t2.start();
    }
}
