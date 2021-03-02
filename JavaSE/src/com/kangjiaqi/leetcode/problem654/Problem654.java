package com.kangjiaqi.leetcode.problem654;

import java.util.Arrays;

public class Problem654 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Problem654 p = new Problem654();
        TreeNode root = p.constructMaximumBinaryTree(nums);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        int maxIndex = argmax(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        int[] leftArray = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightArray = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftArray);
        root.right = constructMaximumBinaryTree(rightArray);
        return root;
    }
    public int argmax(int[] nums) {
        int maxValue = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }
        return index;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
