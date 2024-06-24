package learning.hackerRank.search;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    private static final Scanner scanner = new Scanner(System.in);

    static int pairs(int k, int[] arr) {

        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; arr.length - 1 > i; i++) {
            for (int j = i + 1; arr.length > j; j++) {
                if (k == arr[j] - arr[i]) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        System.out.println(result);

        scanner.close();
    }
}
