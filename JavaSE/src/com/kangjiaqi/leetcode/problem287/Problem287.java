package com.kangjiaqi.leetcode.problem287;

public class Problem287 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Problem287 p = new Problem287();
        int res = p.findDuplicate(nums);
        System.out.println(res);
    }

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = cntSmaller(nums, mid);
            if (cnt == mid) {
                left = mid + 1;
            } else if (cnt < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int cntSmaller(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (num <= target) res++;
        }
        return res;
    }
}
