package com.hackerRank.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Triplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
       /* Long[] array = arr.stream().toArray(Long[]::new);
        long count = 0;
        Arrays.sort(array);
        for (long i = 0; array.length - 2 > i; i++) {
            for (long j = i + 1; array.length - 1 > j; j++) {
                for (long k = j + 1; array.length > k; k++) {
                    if (array[(int) i] * r == array[(int) j] && array[(int) j] * r == array[(int) k]) {
                        count += 1;
                        System.out.println(count);
//                        System.out.println(i + "," + j + "," + k);
                    }
                }
            }
        }

        return count;*/

        long ans = 0;
        Long[] array = new Long[arr.size()];
        Map<Long, Long> right = new HashMap<>();
        Map<Long, Long> left = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
            right.put(array[i], 0l);
            left.put(array[i], 0l);
        }

        for (int i = 0; i < array.length; i++) {
            Long num = array[i];
            right.put(num, right.get(num) + 1);
        }

        for (int i = 0; i < array.length; i++) {
            Long num2 = array[i];
            right.put(num2, right.get(num2) - 1);

            if (num2 % r == 0) {
                Long num1 = num2 / r;
                Long num3 = num2 * r;

                if (left.containsKey(num1) && right.containsKey(num3)) {
                    ans += (left.get(num1) * right.get(num3));
                }
            }

            left.put(num2, left.get(num2) + 1);
        }


        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);


        bufferedReader.close();

    }
}
