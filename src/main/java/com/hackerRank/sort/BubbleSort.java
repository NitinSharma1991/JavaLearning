package com.hackerRank.sort;

import java.util.Scanner;

public class BubbleSort {

    private static final Scanner scanner = new Scanner(System.in);

    static void countSwaps(int[] a) {
        int swaps = 0;

        for (int i = 0; a.length > i; i++) {

            for (int j = 0; a.length - 1 > j; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = 0;
                    swaps += 1;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
        System.out.println(String.format("Array is sorted in %s swaps.", swaps));
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);

    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
