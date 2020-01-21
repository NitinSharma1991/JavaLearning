package com.hackerRank.strings;

public class LongestPalindrome {

    public String findTheLongestPalindrome(String str) {
        if (str == null) {
            return null;
        }
        String longestPalindrome = String.valueOf(str.charAt(0));
        for (int i = 0; i < str.length() - 1; i++) {
            String returnedPalindrome = findLongestPalindromeWithSpecifiedParameter(str, i, i);
            if (returnedPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = returnedPalindrome;
            }
            returnedPalindrome = findLongestPalindromeWithSpecifiedParameter(str, i, i + 1);
            if (returnedPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = returnedPalindrome;
            }
        }
        return longestPalindrome;
    }

    public String findLongestPalindromeWithSpecifiedParameter(String str, int left, int right) {
        if (left > right)
            return null;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println("Longest palindrome in abcmadamcbamadam is " + longestPalindrome.findTheLongestPalindrome("abcmadamcbamadam"));
        System.out.println("Longest palindrome in abcba is " + longestPalindrome.findTheLongestPalindrome("abcba"));
    }
}
