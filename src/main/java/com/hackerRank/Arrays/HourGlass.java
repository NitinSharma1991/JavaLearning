package com.hackerRank.Arrays;

import java.io.IOException;
import java.util.Scanner;

public class HourGlass {

    private static final Scanner scanner = new Scanner(System.in);

    static int hourglassSum(int[][] arr) {

        int max = -64;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][1 + j] + arr[i][2 + j] + arr[1 + i][1 + j] + arr[2 + i][j] + arr[2 + i][1 + j] + arr[2 + i][2 + j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;

            }
        }

        int result = hourglassSum(arr);


        scanner.close();
    }
}
