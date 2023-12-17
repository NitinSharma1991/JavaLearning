package com;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseString {
    static StringBuffer a = new StringBuffer("KaK123");

    public static void main(String[] args) {
        String s = String.valueOf(a);
        String regex = "(.)*(\\\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }

        if (matcher.matches()) {
            System.out.println("matched");
        }

        Optional<String> res = Optional.of(null);

        System.out.println(res.orElse(null));
        System.out.println(reverse);
        System.out.println(s.equalsIgnoreCase(reverse.toString()));
    }
}
