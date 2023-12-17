package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByArray {

    static String[][] student = {{"jerry", "65"}, {"bob", "1"}, {"jerry", "23"}, {"jerry", "23"}, {"jerry", "100"}, {"Eric", "83"}};

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        String a1 = "ABED";
        StringBuilder ans = new StringBuilder();
        for (char a : a1.toCharArray()) {
            ans.append(a);
        }
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

        List<Integer> res = map.values().stream().toList();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            Integer value = map1.get(stringIntegerEntry.getKey());
            System.out.println("Average for student " + stringIntegerEntry.getKey() + " is " + (int) stringIntegerEntry.getValue() / value);
        }

        System.out.println(findTheWinner(10, 2));
    }


    public static int findTheWinner(int n, int k) {

        return winner(n, k) + 1;
    }

    private static int winner(int n, int k) {

        if (n == 1) return 0;

        return (winner(n - 1, k) + k) % n;
    }
}
