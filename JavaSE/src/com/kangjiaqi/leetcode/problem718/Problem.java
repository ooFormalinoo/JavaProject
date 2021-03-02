package com.kangjiaqi.leetcode.problem718;

public class Problem {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA][lenB];
        for (int i = 0; i < lenA; i++) {
            dp[i][0] = B[0] == A[i] ? 1 : 0;
        }
        for (int i = 0; i < lenB; i++) {
            dp[0][i] = A[0] == B[i] ? 1 : 0;
        }
        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                if (A[i] == B[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = 0;
                if (dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }
}
