package com.kangjiaqi.leetcode.problem617;

public class Problem617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        } else if(t1 == null) {
            return t2;
        } else if(t2 == null) {
            return t1;
        } else {
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}