package learning.hackerRank.sort;

import java.util.Arrays;
import java.util.Scanner;

public class MarknToys {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int result = 0, price = 0;

        for (int i : prices) {
            price += i;
            if (price >= k)
                return result;

            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(result);

        scanner.close();
    }
}
