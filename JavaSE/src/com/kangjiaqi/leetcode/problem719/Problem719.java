package com.kangjiaqi.leetcode.problem719;

import java.util.Arrays;

public class Problem719 {
    public static void main(String[] args) {
        Problem719 p = new Problem719();
        int[] nums = {1, 6, 1};
        int result = p.smallestDistancePair(nums, 3);
        System.out.println(result);
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = count(nums, mid);
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 距离小于等于target的数目
    public int count(int[] nums, int target) {
        int left = 0;
        int right = 0;
        int result = 0;
        for (right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }
            result += right - left;
        }
        return result;
    }
}
