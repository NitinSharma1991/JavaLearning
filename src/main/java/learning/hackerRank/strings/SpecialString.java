package learning.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

public class SpecialString {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        long iPalCount = n;
        long iSpecialCnt = 0, iCurrCount = 0, iPrevCount = 0, iPrevPrevCount = 0;

        char[] s1 = s.toCharArray();

        for (int i = 1; i < n; i++) {
            char cPrev = s1[i - 1];
            char cCurr = s1[i];

            if (cPrev == cCurr) {
                iCurrCount++;
                iPalCount += iCurrCount;

                if (iSpecialCnt > 0) {
                    iSpecialCnt--;
                    iPalCount++;
                }
            } else {
                iCurrCount = 0;
                if (i > 1 && (s1[i - 2] == cCurr)) {
                    iSpecialCnt = iPrevPrevCount;
                    iPalCount++;
                } else {
                    iSpecialCnt = 0;
                }
            }

            if (i > 1) {
                iPrevPrevCount = iPrevCount;
            }

            iPrevCount = iCurrCount;
        }

        return iPalCount;
    }

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);

        scanner.close();
    }
}
