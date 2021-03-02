package com.kangjiaqi.leetcode.problem112;

public class Problem112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }

    public boolean helper(TreeNode root, int curSum, int sum) {
        if (root == null) return false;
        if (isLeaf(root)){
            return curSum + root.val == sum;
        } else{
            return helper(root.left, curSum + root.val, sum) || helper(root.right, curSum + root.val, sum);
        }
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}