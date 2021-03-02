package com.kangjiaqi.leetcode.problem_broadview55;

public class Problem_broadview55 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
        return (diff <= 1) && isBalanced(root.right) && isBalanced(root.left);
    }
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}