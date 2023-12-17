package Algorithms;

import java.util.Arrays;

public class NewMergeSort {

    private static final int[] a = {6, 4, 7, 1, 5, 2};

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        mergeSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(System.currentTimeMillis());
    }

    private static void mergeSort(int[] a) {
        int mid = a.length / 2;
        if (a.length < 2) return;
        int[] leftA = new int[mid];
        int[] rightA = new int[a.length - mid];

        System.arraycopy(a, 0, leftA, 0, mid);

        if (a.length - mid >= 0) System.arraycopy(a, mid, rightA, 0, a.length - mid);
        mergeSort(leftA);
        mergeSort(rightA);

        merge(leftA, rightA, a);
    }

    private static void merge(int[] leftA, int[] rightA, int[] a) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftA.length && j < rightA.length) {
            if (leftA[i] < rightA[j]) {
                a[k] = leftA[i];
                i++;
            } else {
                a[k] = rightA[j];
                j++;
            }
            k++;
        }

        while (i < leftA.length) {
            a[k] = leftA[i];
            i++;
            k++;
        }

        while (j < rightA.length) {
            a[k] = rightA[j];
            j++;
            k++;
        }
    }
}
