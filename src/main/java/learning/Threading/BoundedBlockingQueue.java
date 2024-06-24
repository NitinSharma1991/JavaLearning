package learning.Threading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<T> {

    Lock lock;
    int cap;
    private Condition notFull;
    private Condition notEmpty;
    Queue<T> queue;

    BoundedBlockingQueue(int cap) {
        this.cap = cap;
        queue = new ArrayDeque<>(cap);
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }


    void enqueue(T element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == cap) {
                notFull.await();
            }
            notEmpty.signalAll();
            queue.offer(element);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    T dequeue() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            T item = queue.poll();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}

