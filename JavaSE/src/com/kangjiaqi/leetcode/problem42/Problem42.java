package com.kangjiaqi.leetcode.problem42;

public class Problem42 {
    public static void main(String[] args) {
        Problem42 p = new Problem42();
        int[] nums = {4,2,0,3,2,5};
        int result = p.trap(nums);
        System.out.print(result);
    }
    public int trap(int[] height) {
        int len = height.length;
        int[] maxFromBegin = new int[len];
        int[] maxToEnd = new int[len];
        for (int i = 0; i < len; i++) {
            maxFromBegin[i] = i == 0 ? height[0] : Math.max(maxFromBegin[i - 1], height[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            maxToEnd[i] = i == len - 1 ? height[len - 1] : Math.max(maxToEnd[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = maxFromBegin[i - 1];
            int maxRigth = maxToEnd[i + 1];
            int temp = Math.min(maxLeft, maxRigth) - height[i];
            result += Math.max(0, temp);
        }
        return result;
    }
}
