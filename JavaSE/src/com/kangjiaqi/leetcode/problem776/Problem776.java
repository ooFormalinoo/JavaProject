package com.kangjiaqi.leetcode.problem776;

public class Problem776 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] lr;
        if (root.val <= V) {
            lr = splitBST(root.right, V);
            root.right = lr[0];
            lr[0] = root;
        } else {
            lr = splitBST(root.left, V);
            root.left = lr[1];
            lr[1] = root;
        }
        return lr;
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
