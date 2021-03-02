package com.kangjiaqi.leetcode.problem1022;

public class Problem {
    public int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int curSum){
        if(root == null) return;
        if(isLeaf(root)) {
            res = res + curSum * 2 + root.val;
        }
        dfs(root.left, curSum * 2 + root.val);
        dfs(root.right, curSum * 2 + root.val);
    }
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
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
