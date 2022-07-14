package week8.박준우;
/*
    Leetcode 그래프
    746 Min Cost Climbing Stairs
 */
public class Ex_746 {
    class Solution {

        public int minCostClimbingStairs(int[] cost) {

            // memo's each index represent the reach cost till i steps
            int[] memo = new int[cost.length+1];

            // free to move one or two steps
            memo[0] = 0;
            memo[1] = 0;

            for(int i=2; i < memo.length; i++) {
                memo[i] = Math.min( cost[i-1]+memo[i-1], cost[i-2]+memo[i-2] );
            }

            return memo[memo.length-1];
        }

    }
}
