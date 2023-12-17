package interview.recursion;

import java.util.*;

public class CombinationSum {
    static Set<List<Integer>> res = new HashSet<>();

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        combinationSum(arr, arr.length - 1, 0, 7, new LinkedList<Integer>());
        res.forEach(System.out::println);

    }

    private static void combinationSum(int[] arr, int n, int start, int target, LinkedList<Integer> ans) {
        if (start > n || target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i <= n; i++) {
            ans.add(arr[i]);
            combinationSum(arr, n, i, target - arr[i], ans);
            ans.removeLast();
            combinationSum(arr, n, i + 1, target, ans);
        }

    }
}
