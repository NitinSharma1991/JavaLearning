package com.hackerRank.strings;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
