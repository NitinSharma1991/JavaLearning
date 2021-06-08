package interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    static List<String> list = new ArrayList<>();


    public static void main(String[] args) {
        subSequence("abc", "");
        System.out.println(list);
    }

    public static void subSequence(String s, String ans) {
        if (s.isEmpty()) {
            list.add(ans);
            return;
        }
        subSequence(s.substring(1), ans + s.charAt(0));
        subSequence(s.substring(1), ans);
        System.out.println(ans);
    }
}
