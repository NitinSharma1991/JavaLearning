package interview.recursion;

import java.util.Arrays;

public class ReverseAnArray {
    static int[] arr = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(arr));
        reverse(0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(sum(5));
    }

    private static void reverse(int i, int j) {
        if (i > j) return;
        int temp = arr[i];
        arr[i] = arr[j - 1];
        arr[j - 1] = temp;
        reverse(i + 1, j - 1);

    }

    private static int sum(int n) {
        if (n < 0) return 0;

        return n + sum(n - 1);
    }

}
