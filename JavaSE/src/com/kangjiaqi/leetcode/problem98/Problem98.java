package com.kangjiaqi.leetcode.problem98;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}