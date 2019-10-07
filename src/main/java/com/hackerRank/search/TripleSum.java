package com.hackerRank.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TripleSum {
    private static final Scanner scanner = new Scanner(System.in);

    static long triplets(int[] a, int[] b, int[] c) {

        HashMap<String, Integer> map = new HashMap<>();
        int[] a1 = removeDuplicates(a);
        int a2[] = removeDuplicates(b);
        int a3[] = removeDuplicates(c);
        int j = countPair(a1, a2, a3);

        return j;
    }

    private static int countPair(int a[], int b[], int c[]) {
        int j = 0;
        for (int i = 0; b.length > i; i++) {
            for (int k = 0; a.length > k; k++) {
                if (b[i] >= a[k])

                    for (int l = 0; c.length > l; l++) {
                        if (b[i] >= c[l]) j++;
                    }
            }
        }
        return j;

    }

    private static int[] removeDuplicates(int array[]) {
        int arr[] = new int[array.length];
        int i = 0;
        for (int a = 0; a < array.length - 1; a++) {

            if (array[a] != array[a + 1]) {
                arr[i++] = array[a];
            }

        }
        arr[i++] = array[array.length - 1];
        int array1[] = new int[i];
        for (int k = 0; k < i; k++) {
            array1[k] = arr[k];
        }
        return array1;
    }

    public static void main(String[] args) throws IOException {


        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        System.out.println(ans);
        scanner.close();

    }
}
