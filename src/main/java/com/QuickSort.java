package com;

import java.util.Arrays;

public class QuickSort {

    private static int [] array;
    private static int length;
    private static int swaps;

    public static void main(String[] args) {
        int[] a = {4, 3, 4, 9, 1048, 10, 1, 2, 3, 5};
        int[] b = {1,3,5,2,4,6,7};

        sort(b);
        System.out.println(swaps);
    }

    public static void sort(int[] array) {
        if (array == null || array.length < 1) return;
        QuickSort.array = array;
        length = array.length;
        quickSort(0, array.length - 1);
        System.out.println(Arrays.toString(QuickSort.array));
    }

    public static void quickSort(int a, int b) {
        int i = a;
        int j = b;

        int pivot = array[a + (b - a) / 2];

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) j--;

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }

        }
        if (a < j) {
            quickSort(a, j);
        }
        if (i < b) {
            quickSort(i, b);
        }

    }

    private static void swap(int i, int j) {
        swaps++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
