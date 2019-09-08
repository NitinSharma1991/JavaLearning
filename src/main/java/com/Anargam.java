package com;


import java.util.*;

public class Anargam {

    static String s = "Nitin kaka ";
    static String s1 = "Angel";


    public static void main(String[] args) {
        int aa = 10, b1 = 9, cc = 7;
        aa=aa>>b1^cc<<2;
        System.out.println(aa);

        System.out.println(s.equals(s = s1));
        String s2 = sort(s);
        String s3 = sort(s1);
        int i = s2.compareTo(s3);

        System.out.println(Math.min(Float.NaN, Float.POSITIVE_INFINITY));

        byte b = 1;
        byte c = 100;
        int d = (b + c);
        System.out.println(b + c + " " + d);
        System.out.println(i);
        System.out.println("Duplicate Characters in String {} " + duplicateChars(s.toLowerCase()));
        s2 = reverseString(s);
        if (s.equalsIgnoreCase(s2)) System.out.println("String is palindrome {} " + s);
        System.out.println(s2);

        System.out.println("Given String Character Count {} " + countCharacters(s));
    }

    private static String sort(String s) {
        char array[] = s.toLowerCase().toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);

    }

    private static List<Character> duplicateChars(String a) {
        List<Character> list = new LinkedList<>();
        int t = 0;
        HashSet<Character> set = new HashSet();
        for (int i = 0; i <= a.length() - 1; i++) {
            if (!set.contains(a.charAt(i)))
                set.add(a.charAt(i));
            else {
                list.add(a.charAt(i));
            }
        }
        /*print first non repeated character in the string */
        set.removeAll(list);
        System.out.println(set.iterator().next());
        return list;

    }
/*
 Recursive function to reverse String
 */

    public static String reverseString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static Integer countCharacters(String a) {
        HashMap map = new HashMap();
        String b = a.replaceAll("\\s", "");
        for (int i = 0; i < b.length(); i++)
            map.put(i, b.charAt(i));
        return map.size();
    }

}
