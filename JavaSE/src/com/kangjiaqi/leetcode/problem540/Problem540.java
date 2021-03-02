package com.kangjiaqi.leetcode.problem540;

public class Problem540 {
    public static void main(String[] args) {
        Problem540 p = new Problem540();
        int[] nums = {3,3,7,7,10,11,11};
        int res = p.singleNonDuplicate(nums);
        System.out.println(res);
    }
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2 - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid * 2] < nums[mid * 2 + 1]) {
                right = mid - 1;
            } else if(nums[mid * 2] > nums[mid * 2 + 1]) {
                left = mid + 1;
            } else if(nums[mid * 2] == nums[mid * 2 + 1]) {
                left = mid + 1;
            }
        }
        return nums[left * 2];
    }
}
