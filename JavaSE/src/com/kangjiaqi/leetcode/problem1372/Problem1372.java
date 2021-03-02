package com.kangjiaqi.leetcode.problem1372;

public class Problem1372 {
    public int longestZigZag(TreeNode root) {
        if(root == null) return -1;
        int curRoot = Math.max(longest(root, -1), longest(root, 1));
        int subRoot = Math.max(longestZigZag(root.left), longestZigZag(root.right));
        return Math.max(curRoot, subRoot);
    }
    public int longest(TreeNode root, int direction) {
        if(root == null) return -1;
        int path = 0;
        TreeNode p = root;
        while((direction == -1 && p.left != null) || (direction == 1 && p.right != null)) {
            if(direction == -1) {
                p = p.left;
            }
            if(direction == 1) {
                p = p.right;
            }
            direction = -direction;
            path++;
        }
        return path;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}