package learning.hackerRank.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class LillyHomeWork {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        int swaps = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] sArr = arr.clone();
        int[] nsArr = arr.clone();
        Arrays.sort(sArr);

        for (int i = 0; nsArr.length > i; i++) {
            hm.put(nsArr[i], i);
        }

        for (int i = 0; i < nsArr.length; i++) {

            if (nsArr[i] != sArr[i]) {

                swaps++;
                int tmp = hm.get(sArr[i]);
                hm.put(sArr[i], i);
                hm.put(nsArr[i], tmp);
                int tmpO = nsArr[i];
                nsArr[i] = sArr[i];
                nsArr[tmp] = tmpO;

            }

        }

        HashMap<Integer, Integer> hm1 = new HashMap<>();

        Integer[] srArr = new Integer[arr.length];
        for (int i = 0; arr.length > i; i++) {
            hm1.put(arr[i], i);
            srArr[i] = Integer.valueOf(arr[i]);
        }
        int swap = 0;
        Arrays.sort(srArr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != srArr[i]) {

                swap++;
                int tmp = hm1.get(srArr[i]);
                hm1.put(srArr[i], i);
                hm1.put(arr[i], tmp);
                int tmpO = arr[i];
                arr[i] = srArr[i];
                arr[tmp] = tmpO;
            }

        }
        return Math.min(swaps, swap);


    }

    public static void main(String[] args) {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        System.out.println(result);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
