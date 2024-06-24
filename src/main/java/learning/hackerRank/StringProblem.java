package learning.hackerRank;

import java.util.Scanner;

public class StringProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int k = scanner.nextInt();
        String minSubstring = line.substring(0, k);
        String maxSubstring = line.substring(0, k);
        for (int i = 1; i < line.length() - k + 1; i++) {
            String sub = line.substring(i, i + k);
            if (sub.compareTo(minSubstring) < 0) {
                minSubstring = sub;
            }
            if (sub.compareTo(maxSubstring) > 0) {
                maxSubstring = sub;
            }
        }
        System.out.println(minSubstring);
        System.out.println(maxSubstring);
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int sum = A.length() + B.length();

        System.out.println(sum);

        String a = "No";

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (A.charAt(i) < B.charAt(i)) {
                    break;
                } else {
                    a = "yes";
                    break;
                }
            }
        }

        System.out.println(a);
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B);

    }
}
