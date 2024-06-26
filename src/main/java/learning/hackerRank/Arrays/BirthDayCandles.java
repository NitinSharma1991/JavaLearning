package learning.hackerRank.Arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BirthDayCandles {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {

        Arrays.sort(ar);
        int total = 1;
        for (int i = ar.length - 1; i >= 1; i--) {
            if (ar[i] == ar[i - 1]) {
                total++;
            } else break;

        }

        System.out.println(total);
        return total;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
