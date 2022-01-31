package interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String a = "aAbCaZz";
        int[] arr = new int[128];
        for (char c : a.toCharArray()) {
            arr[c - 'A']++;
        }
        System.out.println(Arrays.toString(arr));
//        System.out.println(permute(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {

        ArrayList res = new ArrayList();
        boolean[] vis = new boolean[nums.length];
        LinkedList p = new LinkedList();

        helper(res, nums, vis, p);


        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, boolean[] vis, LinkedList<Integer> p) {


        if (p.size() == nums.length) {
            res.add(new ArrayList(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                p.add(nums[i]);
                vis[i] = true;
                helper(res, nums, vis, p);
                vis[i] = false;
                p.removeLast();
            }
        }
    }
}
