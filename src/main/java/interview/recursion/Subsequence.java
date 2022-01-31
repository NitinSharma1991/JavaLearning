package interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        subSequence("abc", "");
//        permutations("abc", "");
        System.out.println(list);

    }

    public static void subSequence(String s, String ans) {
        if (s.isEmpty()) {
            list.add(ans);
            return;
        }
        subSequence(s.substring(1), ans);
        subSequence(s.substring(1), ans + s.charAt(0));

//        System.out.println(ans);
    }

    private static void permutations(String s, String ans) {

        if (s.isEmpty()) list.add(ans);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = s.substring(0, i) + s.substring(i + 1);

            permutations(ros, ans + ch);
        }
    }
}
