package com.kangjiaqi.leetcode.problem1060;

public class Problem1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int offset = nums[0];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] - offset - mid == k) {
                right = mid - 1;
            } else if(nums[mid] - offset -mid < k) {
                left = mid + 1;
            } else if(nums[mid] - offset - mid > k) {
                right = mid - 1;
            }
        }
        int totalMissing = nums[right] - offset - right;
        return nums[right] + (k - totalMissing);
    }
}
