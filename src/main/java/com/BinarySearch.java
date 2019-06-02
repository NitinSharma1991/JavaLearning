package com;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int arr[] = {4, 3, 4, 9, 10, 1, 2, 3, 5};

    public static void main(String[] args) {
        Arrays.sort(arr);
        Scanner in = new Scanner(System.in);
        boolean b = search(in.nextInt(), 0, arr.length - 1, arr);

        System.out.println(b);

    }

    public static boolean search(int number, int i, int j, int arr[]) {
        int low = 0;
        int high = 0;
        if (j > 1) {
            low = i;
            high = j;
            int b = (low + (high - low) / 2);
            if (arr[b] == number) {
                return true;
            }

            if (arr[b] < number) {
                low = b + 1;
                high = arr.length - 1;
            } else {
                high = b - 1;
                low = 0;

            }
            if (i == j) return false;
        }
        return search(number, low, high, arr);

    }
}