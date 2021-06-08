package Algorithms;

import java.util.Arrays;

public class InsertionSort {

    static int[] arr = {10, 5, 18, 1, -3, 4, 18, 10, 4, 9};

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(insertionSort(arr)));

        System.out.println(Arrays.toString(bubble(arr)));

    }

    private static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                arr[j] = key;
                j = j - 1;
            }

            arr[j + 1] = key;
        }

        return arr;
    }

    private static int [] bubble(int [] arr) {

        for(int i = 0; i<arr.length;i++){

            boolean swapped =false;
            for(int j=0;j<(arr.length-i-1);j++){
                if(arr[j]>=arr[j+1]){
                    int a  = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = a;
                swapped = true;}
            }

            if (!swapped) return arr;
        }
        return arr;
    }


}
