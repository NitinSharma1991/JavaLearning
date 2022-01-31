package interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    Node head = new Node<>(0, 0);
    Node tail = new Node<>(0, 0);
    int capacity;
    Map<K, Node<K, V>> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(new Node(key, node.value));
            return (V) node.value;
        }
        throw new RuntimeException("Key Doesn't Exist in the cache");
    }

    public void putCache(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        } else {
            if (map.size() == capacity) {
                remove(tail.prev);
            }
        }

        insert(new Node(key, value));
    }

    private void insert(Node node) {
        map.put((K) node.key, node);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node<K, V> {

    Node next, prev;
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}