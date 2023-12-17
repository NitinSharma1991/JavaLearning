package interview.recursion;

public class PalindromeString {

    public static void main(String[] args) {

        System.out.println(palindrome("NITIN", 0, 5));
        System.out.println("String Reverse " + reverse("Ankita"));
    }

    private static boolean palindrome(String nitin, int i, int j) {
        if (i >= j - 1) return true;
        if (nitin.charAt(i) != nitin.charAt(j - 1)) return false;
        return palindrome(nitin, i + 1, j - 1);
    }

    private static String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}


