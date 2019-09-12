package com;

public class Gambling {

    public static void main(String[] args) {
        int a = gamling(18, 0);

        System.out.println(a);
    }

    private static int gamling(int i, int i1) {
        int bet = 1;
        int count = 0;
        int count1 = i;

        if (i1 == 0) return i - 1;

        while (count1 != 2 && i1 != 0) {
//            if (bet == 1) count = 2 * bet;

            if (count1 % 2 == 0) {
                count1 = count1 / 2;
                i1--;
                count++;
            } else {
                count1--;
            }

        }
        count = count1 + count;
        return count;

    }
}
