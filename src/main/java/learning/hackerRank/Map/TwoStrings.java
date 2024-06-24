package learning.hackerRank.Map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TwoStrings {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        HashMap<Character, Integer> map = new HashMap();

        char[] chars = s2.toCharArray();
        int i = 0, j = 0;
        while (!(chars.length - 1 < i)) {
            if (map.containsKey(chars[i])) i++;
            else map.put(chars[i], 1);
            i++;
        }
        i = 0;
        String s = "NO";
        System.out.println(map.get(1));
        while (!(s1.length() - 1 < i)) {
            if (map.containsKey(s1.charAt(i)))
                s = "YES";

            i++;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }

        scanner.close();
    }

}
