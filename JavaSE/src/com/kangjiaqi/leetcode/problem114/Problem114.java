package com.kangjiaqi.leetcode.problem114;

public class Problem114 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        Problem114 p = new Problem114();
        TreeNode result = p.helper(n1);

    }
    public void flatten(TreeNode root) {
        TreeNode result = helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left == null && right == null) {
            return root;
        } else if (left == null) {
            root.left = null;
            root.right = right;
            return root;
        } else if (right == null) {
            root.left = null;
            root.right = left;
            return root;
        } else {
            TreeNode leftTail = left;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }
            root.left = null;
            root.right = left;
            leftTail.right = right;
            return root;
        }
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