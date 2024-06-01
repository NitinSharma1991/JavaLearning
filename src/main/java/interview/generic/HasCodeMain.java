package interview.generic;

import java.util.HashMap;

public class HasCodeMain {

    public static void main(String[] args) {
        People a = new People();
        a.setId(10);
        a.setName("Nitin");
        People a1 = new People();
        a1.setId(10);
        a1.setName("Nitin1");
        HashMap<People, Integer> map = new HashMap<>();
        map.put(a,1);
        map.put(a1,1);
        System.out.println(map);
        a1.setName("Nitin");
        System.out.println(map);
        map.put(a1,2);
        System.out.println(map);
        System.out.println(map.get(a1));
        System.out.println(a1.equals(a));


    }
}
