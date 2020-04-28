package com;

public class LCS {

    public static void main(String[] args) {
        String s = "aydtdydusisory";
        String s2 = "aaudydtdgdghrt";
        int k = Lcs(s.toCharArray(), s2.toCharArray(), s.length(), s2.length());
        System.out.println(k);
    }

    private static int Lcs(char[] chars, char[] toCharArray, int length, int i) {

        if (length == 0 || i == 0)
            return 0;

        if (chars[length - 1] == toCharArray[i - 1])
            return 1 + Lcs(chars, toCharArray, length - 1, i - 1);
        else
            return Math.max(Lcs(chars, toCharArray, length, i - 1), Lcs(chars, toCharArray, length - 1, i));
    }
}
