package interview.arrays;

import java.io.IOException;
import java.util.Scanner;

public class LeftRotations {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int ro = d % a.length;
        int rotate = Math.abs(ro - a.length);
        int[] arr = new int[a.length];
        int i = a.length - rotate;
        int j = 0;
        while (rotate != 0) {
            arr[j] = a[i];
            i++;
            j++;
            rotate--;
        }
        int t = 0;
        for (int k = j; k < i; k++) {
            arr[k] = a[t];
            t++;
        }
        return arr;

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

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {

            System.out.println(result[i]);

        }


        scanner.close();
    }
}
