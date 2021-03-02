package com.kangjiaqi.leetcode.problem270;

public class Problem270 {
    public double min = Double.MAX_VALUE;
    public int res = -1;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if(Math.abs(target - root.val) < min) {
            min = Math.abs(target - root.val);
            res = root.val;
        }
        dfs(root.left, target);
        dfs(root.right, target);
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
