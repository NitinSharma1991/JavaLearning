package com.hackerRank.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Frequency {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List ans = new ArrayList<>();
        final int INSERT = 1;
        final int REMOVE = 2;
        final int QUERY = 3;

        Map<Integer, Integer> value2count = new HashMap<>();
        Map<Integer, Integer> count2countOccurrence = new HashMap<>();

        for (List q : queries) {
            int type = (int) q.get(0);
            int value = (int) q.get(1);

            if (type == INSERT) {
                if (value2count.containsKey(value)) {
                    int oldCount = value2count.get(value);
                    int newCount = oldCount + 1;

                    value2count.put(value, newCount);

                    count2countOccurrence.put(oldCount, count2countOccurrence.get(oldCount) - 1);

                    if (!count2countOccurrence.containsKey(newCount)) {
                        count2countOccurrence.put(newCount, 0);
                    }
                    count2countOccurrence.put(newCount, count2countOccurrence.get(newCount) + 1);
                } else {
                    value2count.put(value, 1);
                    if (!count2countOccurrence.containsKey(1)) {
                        count2countOccurrence.put(1, 0);
                    }
                    count2countOccurrence.put(1, count2countOccurrence.get(1) + 1);
                }
            } else if (type == REMOVE) {
                if (value2count.containsKey(value)) {
                    int oldCount = value2count.get(value);
                    int newCount = Math.max(oldCount - 1, 0);

                    value2count.put(value, newCount);

                    count2countOccurrence.put(oldCount, count2countOccurrence.get(oldCount) - 1);

                    if (!count2countOccurrence.containsKey(newCount)) {
                        count2countOccurrence.put(newCount, 0);
                    }
                    count2countOccurrence.put(newCount, count2countOccurrence.get(newCount) + 1);
                }
            } else if (type == QUERY) {
                if (count2countOccurrence.containsKey(value) && count2countOccurrence.get(value) > 0) {
                    ans.add(1);
                } else {
                    ans.add(0);
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        System.out.println(ans);
        bufferedReader.close();

    }
}
