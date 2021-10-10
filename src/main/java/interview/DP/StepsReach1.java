package interview.DP;

public class StepsReach1 {

    public static void main(String[] args) {
        int[] a = new int[15 + 1];
        minimumStepsToReachOne(15, a);
        System.out.println(a[15]);
    }

    private static int minimumStepsToReachOne(int i, int[] memo) {
        if (i <= 1) return 0;
        if (memo[i] > 0) return memo[i];
        int res = minimumStepsToReachOne(i - 1, memo);
        if (i % 2 == 0)
            res = Math.min(res, minimumStepsToReachOne(i / 2, memo));
        if (i % 3 == 0)
            res = Math.min(res, minimumStepsToReachOne(i / 3, memo));
        return memo[i] = res + 1;
    }
}
