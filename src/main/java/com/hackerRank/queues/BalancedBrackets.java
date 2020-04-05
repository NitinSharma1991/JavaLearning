package com.hackerRank.queues;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedBrackets {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Map map = new HashMap();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        for (int i = 0; i < s.length() / 2; i++) {
            Character s1 = (Character) map.get(s.charAt(i));
            if (!(s1 == s.charAt(s.length() - 1 - i))) return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {


        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
