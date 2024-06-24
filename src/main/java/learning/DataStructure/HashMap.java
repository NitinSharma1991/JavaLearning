package learning.DataStructure;

public class HashMap<K, V> {

    private static final int DEF_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    Node<K, V>[] array;
    int size;
    double loadFactor;

    public HashMap() {
        this(DEF_CAPACITY, LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int cap, double loadFactor) {
        if (cap < 0) {
            throw new IllegalArgumentException();
        }
        array = (Node<K, V>[]) new Node[cap];
        size = 0;
        this.loadFactor = loadFactor;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> cur = head;
        while (cur != null) {
            if (equalsKey(key, cur.getKey())) {
                V v = cur.getValue();
                cur.setValue(value);
                return v;
            }
            cur = cur.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (equalsKey(key, cur.getKey())) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }

        for (Node<K, V> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        Node<K, V> pre = null;
        while (cur != null) {
            if (equalsKey(key, cur.getKey())) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    array[index] = null;
                }
                cur.next = null;
                size--;
                return cur.getValue();
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (equalsKey(key, cur.getKey())) {
                return cur.getValue();
            }
            cur = cur.next;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0X7FFFFFFF;
    }

    private boolean equalsKey(K k1, K k2) {
        if (k1 == null && k2 == null) {
            return true;
        }
        if (k1 == null || k2 == null) {
            return false;
        }
        return k1 == k2 || k1.equals(k2);
    }

    private boolean equalsValue(V v1, V v2) {
        if (v1 == null && v2 == null) {
            return true;
        }

        if (v1 == null || v2 == null) {
            return false;
        }

        return v1 == v2 || v1.equals(v2);
    }

    private boolean needRehashing() {
        double ratio = size * 1.0 / array.length;
        return ratio >= loadFactor;
    }

    @SuppressWarnings("unchecked")
    private void rehashing() {
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) new Node[array.length * 2];
        size = 0;
        for (Node<K, V> node : oldArray) {
            while (node != null) {
                put(node.getKey(), node.getValue());
                node = node.next;
            }
        }
    }

    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

}
