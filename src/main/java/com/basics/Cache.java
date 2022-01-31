package com.basics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Cache {
    private static final LinkedList<Integer> deque = new LinkedList<>();
    private static final Set<Integer> set = new HashSet<>();
    private static int capacity;


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
            for (Integer integer : deque) {
                if ((int) integer == a) {
                    break;
                }
                index++;
            }
            deque.remove(index);
        }
        set.add(a);
        deque.push(a);
    }
}
