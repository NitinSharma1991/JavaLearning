package com.hackerRank.sort;

import java.util.Scanner;

public class FraudulentActivity {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int[] count = new int[201];
        int result = 0;
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {
            int median = getMedian(count, d);
            if (median <= expenditure[i]) {
                result++;
            }
            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }
        return result;
    }

    public static int getMedian(int[] count, int d) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if ((2 * sum) == d) {
                return (2 * i + 1);
            } else if ((2 * sum) > d) {
                return (i * 2);
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        scanner.close();
    }
}
