package com.hackerRank.strings;

public class Variable {

    public static void main(String[] args) {
        String input = "javaThisKaka";

        String name = "";
        boolean yes = false;

        char[] arr = input.toCharArray();

        for (int i = 0; input.length() > i; i++) {

            if (arr[i] == '_')
                yes = true;

        }
        boolean replace = false;
        if (yes) {
            for (int i = 0; input.length() > i; i++) {
                if (arr[i] == '_') {
                    replace = true;
                } else if (replace) {
                    replace = false;
                    name = name + Character.toUpperCase(arr[i]);
                } else {
                    name = name + arr[i];
                }
            }
        } else {
            int j = 1;
            for (int i = 0; input.length() > i; i++) {
                char s = input.charAt(i);
                if (Character.isUpperCase(s))
                    name = name + "_" + Character.toUpperCase(input.charAt(i));
                else name = name + input.charAt(i);
                j++;
            }

        }
        System.out.println(name);
    }
}
