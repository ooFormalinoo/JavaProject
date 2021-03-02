package com.kangjiaqi.leetcode.problem668;

public class Problem668 {
    public static void main(String[] args) {
        Problem668 p = new Problem668();
        int res = p.findKthNumber(3, 3, 5);
        System.out.println(res);
    }
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int temp = kthCount(m, n, mid);
            if(temp == k) {
                right = mid - 1;
            } else if(temp > k) {
                right = mid - 1;
            } else if(temp < k) {
                left = mid + 1;
            }
        }
        return left;
    }
    public int kthCount(int m, int n, int target) {
        // 计算m*n的矩阵中<target的数字的数量
        int i = 1, j = n, count = 0;
        while(i <= m && j > 0) {
            if(i*j <= target) {
                count += j;
                i ++;
            }else{
                j --;
            }
        }
        return count;
    }
}
