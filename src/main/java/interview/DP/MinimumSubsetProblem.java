package interview.DP;

import java.util.ArrayList;
import java.util.List;

import static interview.DP.Subset.dp;

public class MinimumSubsetProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 11};
        int sum = 0;
        for (int s : arr) sum += s;

        int n = arr.length;
        boolean[][] memo = new boolean[n + 1][sum + 1];
        dp(arr.length, sum, memo, arr);
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j <= sum / 2; j++) {
            if (memo[n][j]) list.add(j);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, sum - (2 * list.get(i)));
        }
        System.out.println(min);
    }

    private static boolean dfs(int[] nums, int n, int subSetSum, boolean[][] memo) {
        if (subSetSum == 0) return true;
        if (n == 0 || subSetSum < 0) return false;
        if (memo[n][subSetSum]) return memo[n][subSetSum];

        if (nums[n - 1] <= subSetSum) {
            return memo[n][subSetSum] = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                    dfs(nums, n - 1, subSetSum, memo);
        } else {
            return memo[n][subSetSum] = dfs(nums, n - 1, subSetSum, memo);
        }

    }
}
