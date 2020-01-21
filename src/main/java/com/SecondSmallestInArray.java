package com;

public class SecondSmallestInArray {

    static int secondSmallest(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min)
                secondMin = min;
            else if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }

        }

        return secondMin;
    }

    public static void main(String[] args) {


        System.out.println("Second smallest Integer " + secondSmallest(new int[]{4, -3, 2, 4, -2, -1}));
    }
}
