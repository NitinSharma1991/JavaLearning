package interview.DP;

public class FrogJump {

    public static void main(String[] args) {
        int[] cost = {10, 20, -5, 60, 80};
        int[] mem = new int[cost.length];
        mem[0] = 0;
        mem[1] = Math.abs(cost[1] - cost[0]);
        for (int i = 2; i < cost.length; i++) {
            mem[i] = Math.min(mem[i - 1] + Math.abs(cost[i] - cost[i - 1]), mem[i - 2] + Math.abs(cost[i] - cost[i - 2]));
        }
        System.out.println(mem[cost.length - 1]);
    }
}
