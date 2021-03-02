package com.kangjiaqi.leetcode.problem153;

public class Problem153 {
    public static void main(String[] args) {
        Problem153 p = new Problem153();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.print(p.findMin(nums));
    }

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        return Math.min(helper(nums, left, mid), helper(nums, mid + 1, right));
    }
}
