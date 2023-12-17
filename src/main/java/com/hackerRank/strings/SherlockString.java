package com.hackerRank.strings;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockString {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isValid function below.
    static String isValid(String s) {

        Map<Long, Long> counts = s.chars()
                .mapToObj(t -> (char) t)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        switch (counts.size()) {
            case 1 -> {
                return "YES";
            }
            case 2 -> {
                Iterator<Long> it = counts.keySet().iterator();
                boolean result = (Math.abs(it.next() - it.next()) == 1 && (counts.values().stream()
                        .anyMatch(i -> i == 1)));
                if (result) return "YES";
                else return "NO";
            }
            default -> {
                return "NO";
            }
        }
    }

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);
        scanner.close();
    }
}
