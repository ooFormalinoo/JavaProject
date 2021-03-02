package com.kangjiaqi.leetcode.problem222;

public class Problem222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == rightHeight){
            return countNodes(root.right) + (int)Math.pow(2, leftHeight);
        } else {
            return countNodes(root.left) + (int)Math.pow(2, rightHeight);
        }
    }
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + getHeight(root.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}