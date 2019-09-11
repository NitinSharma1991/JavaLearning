package com.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

public class HighestValuePalindrome {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String inputString, int numberOfDigits, int maximumDigitsToBeAltered) {

        String palindrome = "";
        int allDigitsWithoutNine = inputString.replaceAll("9", "").length();
        if (allDigitsWithoutNine <= maximumDigitsToBeAltered) {
            String regex = "[0-8]";
            palindrome = inputString.replaceAll(regex, "9");
            return palindrome;
        }
        StringBuilder strBuilder = new StringBuilder(inputString);
        int nonMatches = 0;

        for (int i = 0; i < numberOfDigits / 2; i++) {
            int mirrorIndex = numberOfDigits - 1 - i;
            if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {
                nonMatches++;
            }
        }

        int indexOfTransition = 0;
        if (nonMatches < maximumDigitsToBeAltered) {

            for (int i = 0; i < numberOfDigits / 2; i++) {
                int mirrorIndex = numberOfDigits - 1 - i;
                if (strBuilder.charAt(i) != '9' && strBuilder.charAt(mirrorIndex) != '9') {
                    if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {
                        nonMatches--;
                    }
                    if (nonMatches > maximumDigitsToBeAltered - 2) {
                        indexOfTransition = i;
                        break;
                    }

                    strBuilder.setCharAt(i, '9');
                    strBuilder.setCharAt(mirrorIndex, '9');
                    maximumDigitsToBeAltered -= 2;

                    if (nonMatches == maximumDigitsToBeAltered) {
                        indexOfTransition = i + 1;
                        break;
                    }

                } else if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {

                    if (Character.getNumericValue(strBuilder.charAt(i)) > Character
                            .getNumericValue(strBuilder.charAt(mirrorIndex))) {
                        strBuilder.setCharAt(mirrorIndex, strBuilder.charAt(i));
                        maximumDigitsToBeAltered--;
                        nonMatches--;
                    } else {
                        strBuilder.setCharAt(i, strBuilder.charAt(mirrorIndex));
                        maximumDigitsToBeAltered--;
                        nonMatches--;
                    }
                }
            }
        }

        for (int i = indexOfTransition; i < numberOfDigits / 2; i++) {
            int mirrorIndex = numberOfDigits - 1 - i;
            if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {
                if (Character.getNumericValue(strBuilder.charAt(i)) > Character
                        .getNumericValue(strBuilder.charAt(mirrorIndex))) {
                    strBuilder.setCharAt(mirrorIndex, strBuilder.charAt(i));
                    maximumDigitsToBeAltered--;
                    if (maximumDigitsToBeAltered == 0) {
                        break;
                    }
                } else {
                    strBuilder.setCharAt(i, strBuilder.charAt(mirrorIndex));
                    maximumDigitsToBeAltered--;
                    if (maximumDigitsToBeAltered == 0) {
                        break;
                    }
                }
            }
        }
        if (!isPalindrome(strBuilder.toString())) {
            return "-1";
        }
        if (strBuilder.toString().length() % 2 != 0
                && maximumDigitsToBeAltered > 0) {
            int midIndex = strBuilder.toString().length() / 2;
            if (strBuilder.charAt(midIndex) != '9') {
                strBuilder.setCharAt(midIndex, '9');
            }
        }
        palindrome = strBuilder.toString();
        return palindrome;
    }

    public static boolean isPalindrome(String inputString) {
        StringBuilder strBuilder = new StringBuilder(inputString);
        if (strBuilder.reverse().toString().equals(inputString)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        System.out.println(result);
        scanner.close();
    }
}
