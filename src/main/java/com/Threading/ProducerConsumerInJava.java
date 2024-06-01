package com.Threading;

import java.util.Random;

public class ProducerConsumerInJava {
    public static void main(String[] args) {
        System.out.println("How to use wait and notify method in Java");
        System.out.println("Solving Producer Consumer Problem");
        BoundedBlockingQueue<Integer> buffer = new BoundedBlockingQueue<>(2);
        int maxSize = 5;
        Thread producer = new Producer1(buffer, maxSize, "PRODUCER");
        Thread consumer = new Consumer1(buffer, maxSize, "CONSUMER");
        producer.start();
        consumer.start();
    }
}

class Producer1 extends Thread {
    private final BoundedBlockingQueue<Integer> queue;
    private final int maxSize;

    public Producer1(BoundedBlockingQueue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            try {
//                System.out.println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Random random = new Random();
            int i = random.nextInt();
            System.out.println("Producing value : " + i);
            try {
                queue.enqueue(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Consumer1 extends Thread {
    private final BoundedBlockingQueue<Integer> queue;
    private final int maxSize;

    public Consumer1(BoundedBlockingQueue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
//            System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
            System.out.println("Consuming value : " + queue.dequeue());
        }
    }
}


