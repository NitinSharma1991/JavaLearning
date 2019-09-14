package com.hackerRank.sort;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BubbleSort {

    private static final Scanner scanner = new Scanner(System.in);

    static void countSwaps(int[] a) {

        int b = a.length;
        Map<Integer, Long> map = Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        Iterator iterator = map.entrySet().iterator();

        Map.Entry entry = (Map.Entry) iterator.next();
        long a1 = (long) entry.getValue();
        Integer b1 = (Integer) entry.getKey();

        if (a1 > a.length / 2) System.out.println(b1);
        else System.out.println(-1);


        /*int swaps = 0;

        for (int i = 0; a.length > i; i++) {

            for (int j = 0; a.length - 1 > j; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = 0;
                    swaps += 1;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
        System.out.println(String.format("Array is sorted in %s swaps.", swaps));
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);*/

    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
