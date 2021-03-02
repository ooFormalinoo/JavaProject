package com.kangjiaqi.leetcode.problem312;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem312 {
    int[][] mem;

    public static void main(String[] args) {
        Problem312 p = new Problem312();
        int[] nums = {3, 1, 5, 8};
        int result = p.maxCoins(nums);
        System.out.println(result);
    }

    public int maxCoins(int[] nums) {
        mem = new int[nums.length + 2][nums.length + 2];
        for(int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[0], -1);
        }
        int[] myNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, myNums, 1, nums.length);
        myNums[0] = 1;
        myNums[myNums.length - 1] = 1;
        return helper(myNums, 0, myNums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left + 1 >= right) return 0;
        if (mem[left][right] != -1) return mem[left][right];
        int result = 0;
        for (int k = left + 1; k < right; k++) {
            int curCoins = nums[left] * nums[k] * nums[right] + helper(nums, left, k) + helper(nums, k, right);
            result = Math.max(result, curCoins);
        }
        mem[left][right] = result;
        return result;
    }
}

