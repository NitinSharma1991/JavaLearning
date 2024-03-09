package interview.threading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    Queue<Double> queue;
    Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition newedCondition = lock.newCondition();

    int size;

    SharedResource(int cap) {
        this.size = cap;
        queue = new ArrayDeque<>();
    }

    public void produce() throws InterruptedException {
        System.out.println("we are going to enter the producer code");
        lock.lock();
        while (true) {

            while (queue.size() == size) {
                notFull.await();
            }
            System.out.println("We are producing data from the queue");
            queue.offer(Math.random());
            newedCondition.signal();
        }


    }


    public void consume() throws InterruptedException {
        System.out.println("we are going to enter the consumer code");
        lock.lock();
        while (true) {
            while (queue.isEmpty()) {
                newedCondition.await();
            }
            System.out.println("We are reading data from the queue" + queue.poll());
            notFull.signal();
        }
    }



}
