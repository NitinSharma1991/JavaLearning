package com;

import java.util.HashMap;
import java.util.Map;

public class GroupByArray {

    static String[][] student = {{"jerry", "65"}, {"bob", "1"}, {"jerry", "23"}, {"jerry", "23"}, {"jerry", "100"}, {"Eric", "83"}};

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        String a1 = "ABED";
        System.out.println(a1.substring(1, 1));

        for (String[] strings : student) {
//            for (int j=0;student.length> j;j++) {
            if (map.containsKey(strings[0])) {
                map1.put(strings[0], map1.get(strings[0]) + 1);
                map.put(strings[0], map.get(strings[0]) + Integer.parseInt(strings[1]));
            } else {
                map.put(strings[0], Integer.valueOf(strings[1]));
                map1.put(strings[0], 1);
            }
        }
//            }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            Map.Entry<String, Integer> entry = stringIntegerEntry;
            Integer value = map1.get(entry.getKey());
            System.out.println("Average for student " + entry.getKey() + " is " + (int) entry.getValue() / value);
        }
    }
}
