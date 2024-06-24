package learning.hackerRank;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
    // store keys of cache
    static Deque<Integer> dq;
    // store references of key in cache
    static HashSet<Integer> map;
    // maximum capacity of cache
    static int csize;

    LRUCache(int n) {
        dq = new LinkedList<>();
        map = new HashSet<>();
        csize = n;
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(3);
        ca.refer(1);
        ca.refer(2);
        ca.refer(1);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }

    /* Refers key x with in the LRU cache */
    public void refer(int x) {
        if (!map.contains(x)) {
            if (dq.size() == csize) {
                int last = dq.removeLast();
                map.remove(last);
            }
        } else {
            /* The found page may not be always the last element, even if it's an
               intermediate element that needs to be removed and added to the start
               of the Queue */

            dq.removeLastOccurrence(x);
        }
        dq.addFirst(x);
        map.add(x);
    }

    // display contents of cache
    public void display() {
        for (Integer integer : dq) {
            System.out.print(integer + " ");
        }
    }
}