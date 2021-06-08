package interview.DP;

import static interview.DP.CountSubsetSum.countsubset;

public class CountDiffSubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 6};
        int sum = 0, diff = 1;
        for (int s : arr) sum += s;
        int n = arr.length;
        sum = (diff + sum) / 2;
        int[][] dp = new int[n + 1][sum + 1];
        countsubset(arr, sum, n, dp);
        System.out.println(dp[n][sum] - diff);
    }
}
