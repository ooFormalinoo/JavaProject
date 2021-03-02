package com.kangjiaqi.leetcode.Problem174;

public class Problem174 {
    public static void main(String[] args) {
        Problem174 p = new Problem174();
        int[][] nums = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int result = p.calculateMinimumHP(nums);
        System.out.println(result);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] dp = new int[M][N];
        dp[M - 1][N - 1] = dungeon[M - 1][N - 1] >= 0 ? 1 : 1 - dungeon[M - 1][N - 1];
        for (int i = N - 2; i >= 0; --i) {
            int cost = dungeon[M - 1][i] - dp[M - 1][i + 1];
            if (cost >= 0) dp[M - 1][i] = dp[i+1][N-1];
            else dp[M - 1][i] = 1 - cost;
        }
        for (int i = M - 2; i >= 0; --i) {
            int cost = dungeon[i][N - 1] - dp[i + 1][N - 1];
            if (cost >= 0) dp[i][N - 1] = dp[i+1][N-1];
            else dp[i][N - 1] = 1 - cost;
        }
        for (int i = M - 2; i >= 0; --i) {
            for (int j = N - 2; j >= 0; --j) {
                int temp = Math.min(dp[i + 1][j], dp[i][j + 1]);
                int cost = dungeon[i][j] - temp;
                if (cost >= 0) dp[i][N - 1] = temp;
                else dp[i][N - 1] = 1 - cost;
            }
        }
        return dp[0][0];
    }
}
