package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int[] arr = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Arrays.sort(arr);
        Scanner in = new Scanner(System.in);
        boolean b = search(in.nextInt(), arr);

        System.out.println(b);

    }

    public static boolean search(int searchValue, int[] array) {
        int left = 0;
        int right = array.length - 1;

// If the only possible location of the value is outside of the current search bounds, it doesn't exist in the array
        while (left <= right) {
            // Calculate a middle value
            int mid = left + (right - left) / 2;

            // If the search value is found at the middle of the current search range
            if (array[mid] == searchValue) {
                return true;
            }
            // If the search value would fall in the left half of the dataset (i.e., less than middle), search left
            else if (searchValue < array[mid]) {
                right = mid - 1;
            }
            // Else, the search value can only fall in the right half of the dataset (i.e., greater than middle), search right
            else {
                // search right
                left = mid + 1;
            }
        }
// This is only reached if the search value was never found
        return false;

    }
}
