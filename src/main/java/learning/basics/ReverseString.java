package learning.basics;

import java.util.HashSet;
import java.util.Set;

public class ReverseString {

    public static void main(String[] args) {
        String s = "kanitin";
        Set<String> stringSet = new HashSet<>();
        stringSet.add("kanitin");
        if (stringSet.contains(s.substring(0, 6))) System.out.println(true);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(new String(arr));
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        if (s.isEmpty())
            return s;

        return reverse(s.substring(1)) + s.charAt(0);
    }


}
