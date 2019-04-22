package com.learning;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int i;
        int[] arr = new int[input];
        arr[0] = 1;
        arr[1] = 1;
        for (i = 2; i <= input - 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));

    }
}
