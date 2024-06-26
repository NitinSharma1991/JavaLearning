package learning.hackerRank.Arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int[] array = new int[a.length];
        int j = 0, k = 0;
        for (int i : a) {
            if (d > 0) {
                array[a.length - d] = a[j];
                d--;
            } else {
                array[k] = a[j];
                k++;
            }
            j++;
        }
        return array;
    }

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        System.out.println(Arrays.toString(a));
        int[] result = rotLeft(a, d);

        System.out.println(Arrays.toString(result));
    }
}
