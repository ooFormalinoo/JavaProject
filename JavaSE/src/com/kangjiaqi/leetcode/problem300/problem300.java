package com.kangjiaqi.leetcode.problem300;

public class problem300 {
    public static void main(String[] args) {
        problem300 p = new problem300();
        int[] nums = {0,1,0,3,2,3};
        int result = p.lengthOfLIS(nums);
        System.out.println(result);
    }
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
