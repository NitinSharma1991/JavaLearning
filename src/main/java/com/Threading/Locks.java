package com.Threading;

import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Locks locks = new Locks();
        new Thread(locks::print).start();
        new Thread(locks::print).start();
    }

    private void print() {
        lock.lock();
        System.out.println("Thread ID" + Thread.currentThread().getId());
//        lock.unlock();
    }
}
