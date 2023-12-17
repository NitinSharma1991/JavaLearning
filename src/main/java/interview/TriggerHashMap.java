package interview;

public class TriggerHashMap {

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(3);

        myHashMap.put("10", 2);
        System.out.println(myHashMap.get("10"));
        myHashMap.put("10", 5);
        myHashMap.put("11", 3);
        myHashMap.put("12", 2);
        System.out.println(myHashMap.containsKey("11"));
        System.out.println(myHashMap.containsKey("30"));
        System.out.println(myHashMap.remove("10"));
        System.out.println(myHashMap.get("20"));
        System.out.println(myHashMap.get("11"));
        System.out.println(myHashMap.get("12"));
        System.out.println(myHashMap.get("10"));
    }
}
