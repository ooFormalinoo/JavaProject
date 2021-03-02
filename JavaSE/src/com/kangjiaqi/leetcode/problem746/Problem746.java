package com.kangjiaqi.leetcode.problem746;
/*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed)
* Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top
* of the floor, and you can either start from the step with index 0, or the step with index 1
* */

/*
* example1
* Input: cost = [10, 15, 20]
* Output: 15
*
* example2
* Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
* Output: 6
* */


public class Problem746 {
    public static void main(String[] args) {
        Problem746 p = new Problem746();
        int[] cost = {10, 15, 20};
        int result = p.minCostClimbingStairs(cost);
        System.out.println(result);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[10001];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int n = cost.length;
        for(int i=2; i<n; i++) {
            dp[i] = Math.min(cost[i] + dp[i-1], cost[i] + dp[i - 2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
