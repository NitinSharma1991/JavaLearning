package com;

public class SecondSmallestInArray {

    static int secondSmallest(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i <= min) {
                secondMin = min;
                min = i;
            } else if (i < secondMin)
                secondMin = i;
        }


        return secondMin;
    }

    public static void main(String[] args) {


        System.out.println("Second smallest Integer " + secondSmallest(new int[]{4, 100, 2, 4, -2, -1}));
    }
}
