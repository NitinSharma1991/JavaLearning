package interview.DP;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 13};
        int sum = 3;
        int n = arr.length;
        Boolean[][] b = new Boolean[arr.length + 1][sum + 1];
        subsetSum(arr, arr.length - 1, b, sum);
        System.out.println(b[n][sum]);
    }

    private static boolean subsetSum(int[] arr, int n, Boolean[][] b, int sum) {
        if (sum == 0) return true;
        if (n < 0 || sum <0) return false;
        if (b[n + 1][sum] != null) return b[n + 1][sum];
            return b[n + 1][sum] = subsetSum(arr, n - 1, b, sum) || subsetSum(arr, n - 1, b, sum - arr[n]);

    }
}
