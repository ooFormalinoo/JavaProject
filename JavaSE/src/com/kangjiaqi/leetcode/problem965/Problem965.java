package com.kangjiaqi.leetcode.problem965;

public class Problem965 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            return true;
        } else if(root.left != null && root.right == null) {
            return isUnivalTree(root.left) && root.val == root.left.val;
        } else if(root.left == null && root.right != null) {
            return isUnivalTree(root.right) && root.val == root.right.val;
        } else {
            return isUnivalTree(root.left) &&
                    isUnivalTree(root.right) &&
                    root.val == root.left.val &&
                    root.left.val == root.right.val;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}