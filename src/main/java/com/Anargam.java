package com;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;

public class Anargam {

    static String s = "Anegl";
    static String s1 = "Angel";

    public static void main(String[] args) {
        String s2 = sort(s);
        String s3 = sort(s1);
        int i = s2.compareTo(s3);

        byte b =  1;
        byte c = 100;
        int d =  (b + c);
        System.out.println(b + c + " " + d);
        System.out.println(i);
    }

    private static String sort(String s) {
        char array[] = s.toLowerCase().toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);

    }

}
