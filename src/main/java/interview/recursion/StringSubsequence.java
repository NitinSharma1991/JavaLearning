package interview.recursion;

public class StringSubsequence {

    public static void main(String[] args) {
        String s = "abcd";

        subsequences(s, "", 0, s.length());
    }

    private static void subsequences(String s, String s1, int i, int n) {

        if (i == n) {
            System.out.println("String " + s1);
            return;
        }

        subsequences(s, s1 + s.charAt(i), i + 1, n);
        subsequences(s, s1, i + 1, n);
    }
}
