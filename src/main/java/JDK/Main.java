package JDK;

import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {
    private final Queue<Integer> buffer;
    private final int maxSize;

    Producer(Queue<Integer> buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (buffer) {
                try {
                    while (buffer.size() == maxSize) {
                        System.out.println("Buffer is full, producer is waiting...");
                        buffer.wait();
                    }
                    System.out.println("Producing: " + i);
                    buffer.offer(i++);
                    buffer.notify(); // Notify consumer that buffer has data
                    Thread.sleep(1000); // Simulate some processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private final Queue<Integer> buffer;

    Consumer(Queue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    while (buffer.isEmpty()) {
                        System.out.println("Buffer is empty, consumer is waiting...");
                        buffer.wait();
                    }
                    int data = buffer.poll();
                    System.out.println("Consuming: " + data);
                    buffer.notify(); // Notify producer that buffer is not full
//                    Thread.sleep(1000); // Simulate some processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 5; // Max size of the buffer

        Thread producerThread = new Thread(new Producer(buffer, maxSize));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

