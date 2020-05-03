package com.basics;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        String s = "kanitin";
        char[] arr = s.toCharArray();
        String s1 = "";
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        s1 = Arrays.toString(arr);
        System.out.println(s1);
    }


}
