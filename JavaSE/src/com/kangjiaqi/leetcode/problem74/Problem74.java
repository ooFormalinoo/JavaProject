package com.kangjiaqi.leetcode.problem74;

public class Problem74 {
    public static void main(String[] args) {
        int[][] a = new int[10][20];
        System.out.println(a.length);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] == target){
                return true;
            } else if(matrix[mid][0] < target) {
                left = mid + 1;
            } else if(matrix[mid][0] > target) {
                right = mid - 1;
            }
        }
        int mBound = left - 1;
        if(mBound < 0) return false;

        left = 0;
        right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mBound][mid] == target){
                return true;
            } else if(matrix[mBound][mid] < target) {
                left = mid + 1;
            } else if(matrix[mBound][mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
