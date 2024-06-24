package learning.hackerRank.queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return "NO";
                char a = 0;

                a = (char) stack.pop();

                if (a == '(') {
                    if (!(s.charAt(i) == ')')) return "NO";
                }
                if (a == '{') {
                    if (!(s.charAt(i) == '}')) return "NO";
                }
                if (a == '[') {
                    if (!(s.charAt(i) == ']')) return "NO";
                }
            }
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
