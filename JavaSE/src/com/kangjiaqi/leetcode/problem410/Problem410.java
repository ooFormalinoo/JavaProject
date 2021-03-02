package com.kangjiaqi.leetcode.problem410;

public class Problem410 {
    public static void main(String[] args) {
        Problem410 p = new Problem410();
        int[] nums = {1, 4, 4};
//        int result = p.splitArray(nums, 3);
        System.out.println(p.legal(nums, 3, 4));
    }

    public int splitArray(int[] nums, int m) {
        int right = 0;
        int left = Integer.MAX_VALUE;
        for (int num : nums) {
            right += num;
            if (num < left) left = num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (legal(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean legal(int[] nums, int m, int max) {
        int sum = 0;
        int segNum = 0;
        for (int num : nums) {
            sum += num;
            while (sum > max) {
                segNum++;
                sum = num;
                if(segNum > m) return false;
            }
        }
        return true;
    }
}
