package com.Threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    Queue<E> queue;
    private final int max;

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int max) {
        this.queue = new LinkedList<>();
        this.max = max;
    }

    public void put(E e) {
        lock.lock();
        try {
            while (queue.size() == max)
                notFull.await();
            queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        E item = null;
        try {
            while (queue.isEmpty())
                notEmpty.await();

            item = queue.remove();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            e.getStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }
}
