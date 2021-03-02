package com.kangjiaqi.leetcode.problem404;

public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    public int helper(TreeNode root, boolean left) {
        if(root == null) return 0;
        if(root.left == null && root.right == null && left) return root.val;
        return helper(root.left, true) + helper(root.right, false);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
