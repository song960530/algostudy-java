package week8.송문준;

public class Sol_746 {
    public int minCostClimbingStairs(int[] cost) {
        int sum[] = new int[cost.length + 2];

        for (int i = 0; i < sum.length; i++) {
            sum[i] = Integer.MAX_VALUE;
        }

        sum[0] = 0; // 시작지점

        for (int i = 0; i < sum.length; i++) {
            int moveSum = sum[i] + (i >= cost.length ? 0 : cost[i]);
            if (moveSum < sum[i + 1]) {
                sum[i + 1] = moveSum;
            }

            if (i == sum.length - 2) {
                break;
            }

            moveSum = sum[i] + (i + 1 >= cost.length ? 0 : cost[i + 1]);
            if (moveSum < sum[i + 2]) {
                sum[i + 2] = moveSum;
            }
        }

        return sum[sum.length - 1];
    }
}
