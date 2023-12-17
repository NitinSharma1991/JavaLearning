package interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    static List<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {

        int[] arr = {3, 2, -1};

//        array(0, arr, arr.length);
        array(0, arr, arr.length);
        List<Integer> list1 = new ArrayList<>();
        int sum = 0, k = 5;
        sum(arr, sum, arr.length - 1, list1, k);
        System.out.println(sum(arr, sum, arr.length - 1, k));
        System.out.println(count);

    }


    /*
     print all subsequences
     */
    private static void array(int i, int[] arr, int n) {
        if (i >= n) {
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        array(i + 1, arr, n);
        list.remove(list.size() - 1);
        array(i + 1, arr, n);

    }

    //print all the numbers of sum k
    private static void sum(int[] arr, int sum, int n, List<Integer> list, int k) {
        if (sum == k) {
            System.out.println(list);
            return;
        }
        if (n < 0) return;
        list.add(arr[n]);
        sum(arr, sum + arr[n], n - 1, list, k);
        list.remove(list.size() - 1);
        sum(arr, sum, n - 1, list, k);
    }

    //count of all sum k in an array
    private static int sum(int[] arr, int sum, int n, int k) {
        if (sum == k) {
            count++;
            return count;
        }
        if (n < 0 || sum > k) return 0;
        return Math.max(sum(arr, sum + arr[n], n - 1, k), sum(arr, sum, n - 1, k));
    }
}
