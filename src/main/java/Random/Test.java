package Random;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 7, 7, 9, 10, 10, 10};
        System.out.println(find(arr));
    }

    private static int find(int[] nums) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= 10) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == 10) idx = mid;
        }
        return idx;

    }
}
