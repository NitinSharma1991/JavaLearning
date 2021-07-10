package interview.DP;

public class CountSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 8, 2};
        int sum = 7;
        int diff = 1;
//        for (int i : arr)
//            sum += i;

//        sum = (diff + sum) / 2;
        int n = arr.length;
        int[][] dp = new int[arr.length + 1][sum + 1];
        /*for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
                if (i >= 1 && j >= 1) {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }*/
        countsubset(arr, sum, n, dp);
        System.out.println(dp[n][sum]);

    }

    public static int countsubset(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][sum] > 0) return dp[n][sum];
        if (arr[n - 1] <= sum)
            return dp[n][sum] = countsubset(arr, sum - arr[n - 1], n - 1, dp) + countsubset(arr, sum, n - 1, dp);
        else
            return dp[n][sum] = countsubset(arr, sum, n - 1, dp);
    }
}
