package learning.hackerRank.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BalancedSums {
    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {

        Integer[] arr1 = arr.toArray(new Integer[arr.size() - 1]);

        if (arr1.length == 1) return "YES";
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int j = 0;
        for (Integer i : arr1) {
            if (map.size() == 0)
                map.put(j, i);
            else map.put(++j, (Integer) map.get(j - 1) + i);
        }
        int k = 0;
        for (int i = arr1.length - 1; i >= 0; i--) {
            if (map1.size() == 0)
                map1.put(k, arr1[i]);
            else map1.put(++k, (Integer) map1.get(k - 1) + arr1[i]);
        }

        for (int i = 0; arr1.length - 1 > i; i++) {
            if (i == 0) {
                Integer a = (Integer) map1.get(arr1.length - 2);
                if (a.compareTo(0) == 0) return "YES";
            } else {
                Integer a = (Integer) map.get(i);
                Integer b = (Integer) map1.get(arr1.length - 1 - i);
                if (a.compareTo(b) == 0) return "YES";
            }
        }

      /*  for (int i = 0; arr1.length - 1 > i; i++) {
            Integer a = sum(i + 1, arr1);

            if (i == 0) {
                if (a == 0) return "YES";
            } else {
                Integer b = (Integer) map.get(i - 1);
                if (a.compareTo(b) == 0) return "YES";
            }
        }*/

        return "NO";
    }

    static Integer sum(int i, Integer[] arr) {
        int a = 0;
        for (int j = i; arr.length > j; j++) {
            a += arr[j];
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
