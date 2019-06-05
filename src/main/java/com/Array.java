package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Array {

    public static void main(String[] args) {
        int[] a = new int[99];
        for (int i = 0; i < 99; i++) {

            if (!(i == 50))
                a[i] = i + 1;
        }

        int[] c = {1, 2, 4, 5};
        int[] e = {1, 2, 2, 3, 5, 5, 2, 3, 3, 2};
        int[] d = {1, 2, 2, 3, 5, 5, 2, 3, 3, 2};

        givenSum(d, 10);

        int b = missingNumber(c);
        sortArray(d);
        duplicateNumber(e);
        largestAndSmallest(e);


        System.out.println("Missing Number in Array {} " + b);
//        System.out.println("Missing Number in Array {} " + Arrays.toString(a));
    }

    private static int missingNumber(int[] array) {

        int a = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (!(++a == array[i]))
                return a;
        }
        return 0;
    }

    private static void duplicateNumber(int[] array) {
        int a;
        if (array.length < 1) {
            System.out.println("no duplicate number found");
        } else {
            Arrays.sort(array);
            for (a = 0; a < array.length - 1; a++) {
                if (array[a] == array[a + 1]) System.out.println(array[a]);
            }

        }

    }

    private static void largestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }

            if (number < smallest) {
                smallest = number;
            }
        }
        System.out.println("Given integer array : " + Arrays.toString(numbers));
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }

    public static void sortArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : arr) {
            if (map.containsKey(value)) {
                Integer count = map.get(value) + 1;
                map.put(value, count);
            } else map.put(value, 1);
        }

        ArrayList<Integer> b = new ArrayList<>(map.keySet());
        map.entrySet().stream()
                .sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue())).forEach(e -> {
            for (int i = 0; i < e.getValue(); i++)
                b.add(e.getKey());
        });

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        b.stream().forEach(i -> System.out.print(i + " "));

    }

    public static void givenSum(int[] arr, int sum) {


        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > sum) return;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > sum) break;
                if (sum == arr[i] + arr[j]) System.out.println("Pair of sum {} " + arr[i] + " " + arr[j]);
            }
        }
    }

}
