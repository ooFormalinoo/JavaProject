package com.kangjiaqi.leetcode.problem979;

public class Problem979 {
    public int res = 0;
    public int distributeCoins(TreeNode root) {
        int temp = dfs(root);
        return res;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = root.val + left + right - 1;
        res += Math.abs(cur);
        return cur;
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