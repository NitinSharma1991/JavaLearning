package interview.DP;

import java.util.Arrays;

public class Fibonacci {
    static int[] arr = {19, 5, 18, 1, -3, 4, 18, 18, 4, 19};

    public static void main(String[] args) {
        int[] a = new int[10 + 1];
        System.out.println(fibonacci(10, a));
        System.out.println(Arrays.toString(a));
    }

    private static int fibonacci(int i, int[] a) {

        if (i == 0 || i == 1) return i;
        if (a[i] != 0) return a[i];
        int res = fibonacci(i - 1, a);
        int res1 = fibonacci(i - 2, a);
        a[i] = res + res1;
        return a[i];
    }

    private static void subSets(int[] a, int sum) {
        int curr = 0;

    }
}
