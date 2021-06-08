package Algorithms;

import java.util.Arrays;

public class NewQuickSort {
    private static final int[] a = {6, 4, 7, 1, 5, 2};

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(System.currentTimeMillis());
    }

    private static void quickSort(int[] a, int start, int end) {
        if (end > start) {
            int index = partition(a, start, end);
            quickSort(a, start, index - 1);
            quickSort(a, index, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int index = start;
        int pivot = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(i, index);
                index++;
            }
        }

        swap(index, end);

        return index;
    }

    private static void swap(int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }
}
