package learning.hackerRank.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlour {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        Map<Integer, Integer> complements = new HashMap();

        for (int i = 0; i < cost.length; i++) {
            if (complements.containsKey(cost[i]))
                System.out.println(complements.get(cost[i]) + " " + (i + 1));
            else
                complements.put(money - cost[i], i + 1);
        }


    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
