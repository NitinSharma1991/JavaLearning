package interview.DP;

public class Subset {


    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int sum = 11;
        int n = arr.length;
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        System.out.println(subsetSum(arr, sum));
//        dp(arr.length, sum, dp, arr);
//        subset(arr, sum, arr.length, dp);
        System.out.println(dp[n][sum]);
    }

    public static void dp(int n, int sum, boolean[][] dp, int arr[]) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
                if (i >= 1 && j >= 1) {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
    }

    private static boolean subset(int[] arr, int sum, int n, boolean[][] dp) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (dp[n][sum]) return dp[n][sum];
        if (arr[n - 1] <= sum)
            return dp[n][sum] = subset(arr, sum - arr[n - 1], n - 1, dp) || subset(arr, sum, n - 1, dp);
        else
            return dp[n][sum] = subset(arr, sum, n - 1, dp);
    }

    public static boolean subsetSum(int[] nums, int s) {
        boolean[] dp = new boolean[s + 1];
        dp[0] = true;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] = dp[i - n];
        return dp[s];
    }
}






