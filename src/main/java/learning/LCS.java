package learning;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class LCS {

    public static void main(String[] args) {
        Instant now = Instant.now();
        String s = "aydtdydusisory";
        String s2 = "aaudydtdgdghrt";
        int[][] dp = new int[s.length() + 1][s2.length() + 1];
        for (int[] d : dp) Arrays.fill(d, -1);

        int k = Lcs(s.toCharArray(), s2.toCharArray(), s.length(), s2.length(), dp);
        System.out.printf("Time taken to complete the LCS is %s ms and output is %s", Duration.between(now, Instant.now()).toMillis(), k);
    }

    private static int Lcs(char[] chars, char[] toCharArray, int length, int i, int[][] dp) {
        if (length == 0 || i == 0)
            return 0;

        if (dp[length][i] != -1) return dp[length][i];

        if (chars[length - 1] == toCharArray[i - 1])
            return dp[length][i] = 1 + Lcs(chars, toCharArray, length - 1, i - 1, dp);
        else
            return dp[length][i] = Math.max(Lcs(chars, toCharArray, length, i - 1, dp), Lcs(chars, toCharArray, length - 1, i, dp));
    }
}
