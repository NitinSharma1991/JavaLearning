package com;


import java.util.*;

import static java.util.stream.Collectors.*;

public class Array {

    public static void main(String[] args) {
        int[] a = new int[99];
        for (int i = 0; i < 99; i++) {

            if (!(i == 50))
                a[i] = i + 1;
        }

        int[] c = {4, -1, 2, 1};
        int[] e = {1, 2, 2, 3, 5, 5, 2, 3, 3, 2};
        int[] d = {1, 2, 2, 3, 5, 5, 2, 3, 3, 2};
        int arr[] = {2, 3, 4, -1, 6, 8, 9, 11};
        Arrays.sort(arr);
        groupBy(d);
        printPair(arr, 5);
        sumOddDivisors(c);
        givenSum(d, 10);

        int b = missingNumber(c);
        sortArray(d);
        duplicateNumber(e);
        largestAndSmallest(e);
        List<Integer> list1 = Arrays.stream(e).boxed().collect(toCollection(ArrayList::new));
        Integer sum = list1.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> list = oddNumbers(3, 9);
        System.out.println("Kaka " + list);

        System.out.println("Missing Number in Array {} " + b);

        System.out.println("MaxSum " + maxSum(c));
//        System.out.println("Missing Number in Array {} " + Arrays.toString(a));
    }

    private static int missingNumber(int[] array) {

        int a = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (!(++a == array[i]))
                return a;
        }
        return 0;
    }

    private static void duplicateNumber(int[] array1) {
        int i;
        int[] arr = {1, 3, 2, 3};
        for (i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.println("\nDuplicate " + Math.abs(arr[i]));
        }

    }

    private static void largestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }

            if (number < smallest) {
                smallest = number;
            }
        }
        System.out.println("Given integer array : " + Arrays.toString(numbers));
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }

    public static void sortArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : arr) {
            if (map.containsKey(value)) {
                Integer count = map.get(value) + 1;
                map.put(value, count);
            } else map.put(value, 1);
        }

        ArrayList<Integer> b = new ArrayList<>(map.keySet());
        map.entrySet().stream()
                .sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue())).forEach(e -> {
            for (int i = 0; i < e.getValue(); i++)
                b.add(e.getKey());
        });

        Map.Entry<Integer, Integer> map1 = Collections.max(map.entrySet(), (k1, k2) -> k1.getValue().compareTo(k2.getValue()));

        System.out.println("Max Value" + map1.getValue());

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        b.stream().forEach(i -> System.out.print(i + " "));


    }

    public static void givenSum(int[] arr, int sum) {


        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > sum) return;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > sum) break;
                if (sum == arr[i] + arr[j]) System.out.println("Pair of sum {} " + arr[i] + " " + arr[j]);
            }
        }
    }

    public static void sumOddDivisors(int[] arr) {


        long sum = 0;

        for (int i : arr) {
            if (i % 2 != 0 && i != 1) sum += 1;
            int number = 0;
            while (number <= i / 2) {
                number += 1;
                if ((number % 2 != 0) && (i % number == 0))
                    sum += 1;
            }
        }
        System.out.println("Sum of odd divisors {} " + sum);
    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; r >= i; i++) {
            if (i % 2 == 1)
                list.add(i);
        }
        return list;
    }

    static void printPair(int[] arr, int sum) {

        int low = 0;
        int high = arr.length - 1;
        int pair = 0;
        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                pair++;
               /* System.out.println("The pair is : ("
                        + arr[low] + ", " + arr[high] + ")");*/
            }
            if (arr[low] + arr[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
        System.out.println(pair);
        List<Integer> list = Arrays.stream(arr).boxed().collect(toList());
        Integer[] a1 = list.stream().toArray(Integer[]::new);
        long t1 = System.currentTimeMillis();
        Integer sum1 = list.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println("Sum " + sum1);
    }

    static void groupBy(int[] a) {

        List<String> list = Arrays.asList("Zohne", "Redy", "Zohne", "Redy", "Stome");

            String [] arr = (String[]) list.toArray();
//        System.out.println(list);
        Map<String, Long> map = list.stream().collect(groupingBy(string -> string, counting()));
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    private static int maxSum(int[] a) {
        int ans = Integer.MIN_VALUE;
        int a1 = 0;

        for (int num : a) {
            a1 += num;
            ans = Math.max(ans, a1);
            a1 = Math.max(a1, 0);
        }

        return ans;
    }

}
