package Algorithms;

import java.util.Arrays;

public class NewMergeSort {

    private static int[] a = {6, 4, 7, 1, 5, 2};

    public static void main(String[] args) {
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a) {
        int mid = a.length / 2;
        if (a.length < 2) return;
        int[] leftA = new int[mid];
        int[] rightA = new int[a.length - mid];

        for (int i = 0; i < mid; i++) {
            leftA[i] = a[i];
        }

        for (int i = mid; i < a.length; i++) {
            rightA[i - mid] = a[i];
        }
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
