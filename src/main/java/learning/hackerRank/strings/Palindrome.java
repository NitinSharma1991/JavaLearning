package learning.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

public class Palindrome {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {

        StringBuilder b = new StringBuilder(s);
        String c = b.reverse().toString();
        if (c.equals(s)) return 0;

        char[] a = s.toCharArray();
        int count = 0;
        int middle = a.length / 2;
        int last = a.length - 1;
        for (int i = 0; middle > i; i++) {
            char reduce, toReduce;
            if (a[i] != a[last]) {
                if (a[i] > a[last]) {
                    reduce = a[i];
                    toReduce = a[last];
                } else {
                    reduce = a[last];
                    toReduce = a[i];
                }

                while (reduce != toReduce) {
                    count++;
                    reduce = (char) (reduce - 1);
                }

            }
            last--;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
