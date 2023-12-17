package interview;

import java.util.Objects;

public class MyHashMap<K, V> {

    Node<K, V>[] entrySet;
    int capacity;

    MyHashMap(int capacity) {
        this.capacity = capacity;
        entrySet = new Node[capacity];
    }


    V get(K key) {

        int idx = hashCode(key);

        if (entrySet[idx] == null) {
            return null;
        } else {
            Node<K, V> cur = entrySet[idx];
            while (cur != null) {
                if (cur.key == key) {
                    return (V) cur.value;
                }
                cur = cur.next;
            }

        }

        return null;
    }

    V remove(K key) {
        int idx = hashCode(key);
        if (!containsKey(key)) return null;
        Node<K, V> node = entrySet[idx];
        Node<K, V> previous = null;
        while (node != null) {
            if (node.key == key && previous == null) {
                entrySet[idx] = node.next;
                return node.value;
            } else if (node.key == key) {
                previous.next = node.next;
                return node.value;
            } else {
                previous = node;
                node = node.next;
            }
        }

        return null;
    }

    void put(K key, V value) {
        int idx = hashCode(key);
        if (entrySet[idx] == null) {
            entrySet[idx] = new Node<>(key, value);
        } else {
            Node<K, V> cur = entrySet[idx];
            Node<K, V> prev = null;
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }

            assert prev != null;
            prev.next = new Node<>(key, value);
        }
    }

    boolean containsKey(K key) {

        int idx = hashCode(key);

        if (entrySet[idx] == null) {
            return false;
        } else {
            Node<K, V> cur = entrySet[idx];
            while (cur != null) {
                if (cur.key == key) {
                    return true;
                }
                cur = cur.next;
            }
        }

        return false;
    }

    private int hashCode(K key) {
        return Objects.hash(key) % capacity;
    }

    static class Node<K, V> {
        Node<K, V> next;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
