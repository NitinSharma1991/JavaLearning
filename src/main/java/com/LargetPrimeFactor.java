package com;

public class LargetPrimeFactor {

    public static void main(String[] args) {

        System.out.printf("Largest prime factor of number '%d' is %d %n",
                6, largestPrimeFactor(6));
        System.out.printf("highest prime factor of number '%d' is %d %n",
                15, largestPrimeFactor(15));
        System.out.printf("Biggest prime factor of number '%d' is %d %n",
                392832, largestPrimeFactor(392832));
        System.out.printf("Largest prime factor of number '%d' is %d %n",
                1787866, largestPrimeFactor(1787866));
    }

    /**
     * @return largest prime factor of a number
     */
    public static int largestPrimeFactor(long number) {
        int i;
        long copyOfInput = number;

        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                copyOfInput /= i;
                i--;
            }
        }

        return i;
    }

}
