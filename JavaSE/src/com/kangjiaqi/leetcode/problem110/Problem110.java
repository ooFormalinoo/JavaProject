package com.kangjiaqi.leetcode.problem110;
/*Given a binary tree, determine if it is height-balanced
* a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
* */

public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
