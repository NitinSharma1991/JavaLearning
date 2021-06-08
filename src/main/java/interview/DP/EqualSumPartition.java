package interview.DP;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 8, 1};

        int sum = 0;
        for (int s : arr) sum += s;

        int n = arr.length;

        if (sum % 2 == 1) System.out.println(false);
        else {
            int subSetSum = sum / 2;
            Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
            System.out.println(dfs(arr, n - 1, subSetSum, memo));
        }
    }

    private static boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;
        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];
        return memo[n][subSetSum] = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);
    }

}
