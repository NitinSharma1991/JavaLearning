package com.hackerRank.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CountInversion {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int n = arr.length;

        // Base Case
        if (n <= 1) {
            return 0;
        }

        // Recursive Case
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        long inversions = countInversions(left) + countInversions(right);

        int range = n - mid;
        int iLeft = 0;
        int iRight = 0;
        for (int i = 0; i < n; i++) {
            if (
                    iLeft < mid
                            && (
                            iRight >= range || left[iLeft] <= right[iRight]
                    )
            ) {
                arr[i] = left[iLeft++];
                inversions += iRight;
            } else if (iRight < range) {
                arr[i] = right[iRight++];
            }
        }

        return inversions;
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);
            System.out.println(Arrays.toString(arr));
        }

        scanner.close();
    }
}
