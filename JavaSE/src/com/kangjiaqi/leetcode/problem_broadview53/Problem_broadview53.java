package com.kangjiaqi.leetcode.problem_broadview53;

public class Problem_broadview53 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > mid) {
                right = mid - 1;
            } else if(nums[mid] == mid) {
                left = mid + 1;
            }
        }
        return left;
    }
}
