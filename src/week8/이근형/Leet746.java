package week8.이근형;

public class Leet746 {

    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length -2]);
    }

    public int minCostClimbingStairs1(int[] cost) { // dp - top down(use memoization)
        int[] dp = new int[cost.length + 1];
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length -1];
    }

    public int minCostClimbingStairs2(int[] cost) { //dp - bottom up
        int step1 = 0;
        int step2 = 0;

        for(int i = cost.length - 1; i >= 0; i++) {
            int curn = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = curn;
        }
        return Math.min(step1, step2);
    }
}
