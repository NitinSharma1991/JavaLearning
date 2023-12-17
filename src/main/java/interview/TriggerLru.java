package interview;

public class TriggerLru {

    public static void main(String[] args) {

        LRUCache<String, String> lruCache = new LRUCache(3);
        lruCache.putCache("N", "A");
        System.out.println(lruCache.get("N"));
    }
}
