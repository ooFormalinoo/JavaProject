package com.kangjiaqi.leetcode.problem1123;

public class Problem1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (depth(root.left) == depth(root.right)) {
            return root;
        } else if (depth(root.left) > depth(root.right)) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    public int depth(TreeNode root) {
        return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
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