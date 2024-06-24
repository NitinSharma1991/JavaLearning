package learning.hackerRank.Map;

import java.io.IOException;
import java.util.*;

public class Climbing {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the climbingLeaderboard function below.
    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        Set<Integer> set = new HashSet<Integer>();

        for (int i : scores) {
            set.add(i);
        }
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList, Collections.reverseOrder());
        int ind;
        for (int i = 0; i < alice.length; i++) {
            ind = Collections.binarySearch(sortedList, alice[i], Collections.reverseOrder());
            if (ind < 0) {
                ind = Math.abs(ind);
            } else {
                ind++;
            }

            result[i] = ind;

        }
        return result;
    }

    public static void main(String[] args) throws IOException {


        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        System.out.println(Arrays.toString(result));


        scanner.close();
    }
}
