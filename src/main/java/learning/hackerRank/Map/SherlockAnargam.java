package learning.hackerRank.Map;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAnargam {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int n = s.length();
        int res = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r < n; r++) {
                int[] cntL = new int[26];
                int[] cntR = new int[26];
                for (int k = 0; r + k < n; k++) {
                    cntL[s.charAt(l + k) - 'a']++;
                    cntR[s.charAt(r + k) - 'a']++;
                    if (Arrays.equals(cntL, cntR))
                        res++;
                }
            }
        }
        return res;
    }

    private static String sort(String s) {
        char[] array = s.toLowerCase().toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);

    }

    public static void main(String[] args) throws IOException {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
