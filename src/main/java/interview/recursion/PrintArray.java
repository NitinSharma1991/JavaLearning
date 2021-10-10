package interview.recursion;

import javafx.util.Pair;

import java.util.*;

public class PrintArray {

    static int[] arr = {19, 5, 18, 1, -3, 4, 18, 18, 4, 19};
    //    static int[] arr = {5,8,9};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        PriorityQueue<Object> queue = new PriorityQueue<>();
        List list = new ArrayList();
        list.add(1);
        list.add(0, 2);

        System.out.println(list);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > 1) queue.poll();
        }
        topFrequentNumber();
//        System.out.println(queue.poll());
        list = print(arr, 0, 18);
        System.out.println(list);
        maxSubArraySum();
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    private static List<Integer> print(int[] a, int idx, int data) {
        if (idx == arr.length) return null;
        if (a[idx] == data) {
            list.add(idx);
        }
        print(a, idx + 1, data);
        return list;
    }

    private static void topFrequentNumber() {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }

        }

        //top k frequent
        map.forEach((key, value) -> {
            queue.add(new Pair<>(value, key));
//            if (queue.size() > k) queue.poll();
        });
//        queue.forEach(a-> System.out.println(a.getValue()));
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.printf("Top frequent Number %s%n", Objects.requireNonNull(queue.poll()).getValue());
        }
    }

    private static void maxSubArraySum() {
        int currentArray = arr[0], maxarray = arr[0];

        for (int i = 1; arr.length > i; i++) {
            currentArray += arr[i];
            currentArray = Math.max(arr[i], currentArray);
            maxarray = Math.max(currentArray, maxarray);
        }

        System.out.println(maxarray);
    }

    public static int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }
}
