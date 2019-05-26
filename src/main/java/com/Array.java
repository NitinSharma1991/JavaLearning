package com;


import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        int a[] = new int[99];
        for (int i = 0; i < 99; i++) {

            if (!(i == 50))
                a[i] = i + 1;
        }

        int c[] = {1, 2, 4, 5};
        int d[] = {1, 2, 2, 3, 5, 5, -1};

        int b = missingNumber(c);
        duplicateNumber(d);
        largestAndSmallest(d);

        System.out.println("Missing Number in Array {} " + b);
//        System.out.println("Missing Number in Array {} " + Arrays.toString(a));
    }

    public static int missingNumber(int array[]) {

        int a = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (!(++a == array[i]))
                return a;
        }
        return 0;
    }

    public static void duplicateNumber(int array[]) {
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

    public static void largestAndSmallest(int[] numbers) {
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

}
