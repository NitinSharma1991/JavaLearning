package com.basics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Cache {
    private static final LinkedList<Integer> deque = new LinkedList();
    private static int capacity;
    private static final Set set = new HashSet();


    public Cache(int capacity) {
        Cache.capacity = capacity;
    }

    public static void main(String[] args) {
        Cache cache = new Cache(10);

        cache.putCache(5);
        cache.putCache(2);
        cache.putCache(10);
        cache.putCache(4);
        cache.putCache(10);
        deque.forEach((o) -> System.out.println(o));
    }

    private void putCache(int a) {

        if (!set.contains(a)) {
            if (deque.size() == capacity) {
                int last = deque.removeLast();
                set.remove(last);
            }
        } else {

            int index = 0;
            Iterator iterator = deque.iterator();
            while (iterator.hasNext()) {
                if ((int) iterator.next() == a) {
                    break;
                }
                index++;
            }
            System.out.println(index);
            deque.remove(index);
        }
        set.add(a);
        deque.push(a);
    }
}
