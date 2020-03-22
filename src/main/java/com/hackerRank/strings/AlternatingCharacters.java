package com.hackerRank.strings;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AlternatingCharacters {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s2) {
        char array[] = s2.toCharArray();
        int count = 0;
        for (int i = 0; array.length - 1 > i; i++) {
            if (array[i] == array[i + 1])
                count++;
        }

        return count;
    }

    static char firstNonRepeatingCharacter(String s) {

        char a = 0;

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), Integer.valueOf(map.get(s.charAt(i))) + 1);
            else map.put(s.charAt(i), 1);
        }

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();

            if ((int) entry.getValue() == 1) {
                a = (char) entry.getKey();
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

//            int result = alternatingCharacters(s);
            char result = firstNonRepeatingCharacter(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
