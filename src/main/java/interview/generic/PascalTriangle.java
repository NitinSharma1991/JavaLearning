package interview.generic;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            l.add(0, 1);
            for (int j = 1; j < l.size() - 1; j++) {
                l.set(j, l.get(j) + l.get(j + 1));
            }
            res.add(new ArrayList<>(l));
        }

        return res;
    }
}
