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
        HashMap<String, Integer> map = new HashMap();
        if (map.getOrDefault("nitin", 0) > 1)
            System.out.println(true);
        System.out.println(a1.equals(a));
    }
}
