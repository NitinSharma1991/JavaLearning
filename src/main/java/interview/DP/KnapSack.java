package interview.DP;

import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120, 1000};
        int[] wt = new int[]{10, 20, 30, 10};
        int W = 50;
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        knapSack(W, n - 1, val, wt, dp);
        System.out.println(dp[n][W]);

    }

    public static int knapSack(int w, int n, int[] val, int[] wt, int[][] dp) {
        if (w <= 0 || n < 0) return 0;
        if (dp[n + 1][w] != -1) return dp[n + 1][w];

        if (wt[n] <= w) {
            return dp[n + 1][w] = Math.max(val[n] + knapSack(w - wt[n], n - 1, val, wt, dp), knapSack(w, n - 1, val, wt, dp));
        } else {
            return dp[n + 1][w] = knapSack(w, n - 1, val, wt, dp);
        }

    }
}
