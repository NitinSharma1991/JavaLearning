package com.Threading;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 12; i++) {
            try {
                blockingQueue.put("Producer");
                System.out.println("in Prod -> " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
