package com.Arryas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatedNumbers {

    public static void main(String[] args) {
        int arr[] = {1, 10, 4, 10, 5, 10};
        repeatedNumbers(arr);
    }

    private static void repeatedNumbers(int[] arr) {

        Set<Integer> set = new HashSet();

        for (int i : arr) {
            if (set.contains(i)) System.out.println(i);
            else set.add(i);
        }

        arr = set.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(arr));
    }
}
