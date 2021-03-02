package com.kangjiaqi.leetcode.problem378;

public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(cntK(matrix, mid) == k) {
                right = mid - 1;
            } else if(cntK(matrix, mid) > k) {
                right = mid - 1;
            } else if(cntK(matrix, mid) < k) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int cntK(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        int cnt = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                cnt += j;
                i++;
            } else {
                j--;
            }
        }
        return cnt;
    }
}
