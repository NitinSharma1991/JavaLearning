package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupbyArray {

    static String student[][] = {{"jerry", "65"}, {"bob", "1"}, {"jerry", "23"}, {"jerry", "23"}, {"jerry", "100"}, {"Eric", "83"}};

    public static void main(String[] args) {
        List list = new ArrayList();

        HashMap<String, Integer> map = new HashMap();
        HashMap<String, Integer> map1 = new HashMap();

        for (int i = 0; student.length > i; i++) {
//            for (int j=0;student.length> j;j++) {
            if (map.containsKey(student[i][0])) {
                map1.put(student[i][0], Integer.valueOf(map1.get(student[i][0])) + Integer.valueOf(1));
                map.put(student[i][0], Integer.valueOf(map.get(student[i][0])) + Integer.valueOf(student[i][1]));
            } else {
                map.put(student[i][0], Integer.valueOf(student[i][1]));
                map1.put(student[i][0], Integer.valueOf(1));
            }
//            }
        }


    }
}
