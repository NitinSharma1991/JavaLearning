package interview.string;

public class LongestCommonSubsequence {
    int[][] dp = new int["abcde".length() + 1]["abfcde".length() + 1];

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "abfcde", "abcde".length(), "abfcde".length()));
    }

    public int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (text1.isEmpty() || text2.isEmpty()) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (text1.charAt(0) == text2.charAt(0)) {
            return dp[i][j] = 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1), text1.substring(1).length(), text2.substring(1).length());
        } else {
            return dp[i][j] = Math.max(longestCommonSubsequence(text1, text2.substring(1), text1.length(), text2.substring(1).length()),
                    longestCommonSubsequence(text1.substring(1), text2, text1.substring(1).length(), text2.length()));
        }
    }
}
