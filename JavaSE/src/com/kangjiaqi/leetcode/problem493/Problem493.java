package com.kangjiaqi.leetcode.problem493;

import java.util.Arrays;

public class Problem493 {
    public static void main(String[] args) {
        Problem493 p = new Problem493();
        int[] nums = {1, 3, 2, 3, 1};
        int result = p.reversePairs(nums);
        System.out.println(result);
    }

    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    public int merge(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (right + left) >> 1;
        int leftNum = merge(nums, left, mid);
        int rightNum = merge(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > 2 * (long) nums[j]) {
                cnt = cnt + mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        int[] sorted = new int[right - left + 1];
        i = left;
        j = mid + 1;
        int p = 0;
        while (i <= mid || j <= right) {
            if (i > mid) {
                sorted[p] = nums[j];
                p++;
                j++;
            } else if (j > right) {
                sorted[p] = nums[i];
                p++;
                i++;
            } else {
                if (nums[i] < nums[j]) {
                    sorted[p] = nums[i];
                    p++;
                    i++;
                } else {
                    sorted[p] = nums[j];
                    p++;
                    j++;
                }
            }
        }
        for (i = 0; i < sorted.length; i++) {
            nums[left + i] = sorted[i];
        }
        return cnt + leftNum + rightNum;
    }
}

