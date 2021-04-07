package interview.arrays;

import java.util.Arrays;

public class MissingNumber {

    static int[] a = new int[100];

    public static void main(String[] args) {
        int i = 0;
        while (i < 100) {
            if (i != 45)
                a[i] = i;
            i++;
        }
        int num = missingNumber(a);
        System.out.println(num);

    }

    private static int missingNumber(int[] a) {
        int sum = Arrays.stream(a).sum();
        int i = 1, arraySum = 0;
        while (i < 100) {
            arraySum += i;
            i++;
        }

        return arraySum - sum;
    }
}
