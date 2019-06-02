package com.DataStructure;

import java.util.*;
import java.util.stream.Collectors;

public class Maps {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("kaka", 10);
        map.put("private", 1);
        map.put("private1", 4);
        map.put("private2", 12);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
//        System.out.println(entry);
        ArrayList<Integer> list = new ArrayList<>();
        entry.stream().sorted((k, k1) -> k.getValue().compareTo(k1.getValue())).forEach(list1 -> list.add(list1.getValue()));
        System.out.println(list);

        Map<String, Integer> map1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(map1);
    }
}

