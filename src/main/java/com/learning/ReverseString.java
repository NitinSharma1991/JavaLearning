package com.learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseString {
    static StringBuffer a = new StringBuffer("KaK");

    public static void main(String[] args) {
        String s = String.valueOf(a);
        s.toLowerCase();
        String regex = "(.)*(\\\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }

        if (matcher.matches()) {
            System.out.println("matched");
        }
        System.out.println(reverse);
        System.out.println(s.equalsIgnoreCase(reverse));
    }
}
