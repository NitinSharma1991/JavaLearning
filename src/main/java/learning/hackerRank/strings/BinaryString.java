package learning.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

public class BinaryString {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        char[] a = b.toCharArray();
        int count = 0;
        for (int i = 0; a.length - 2 > i; i++) {
            if (a[i] == 48 && a[i + 1] == 49 && a[i + 2] == 48) {
                count++;
                a[i + 2] = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        System.out.println(result);

        scanner.close();
    }
}
