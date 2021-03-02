package com.kangjiaqi.leetcode.problem450;

public class Problem450 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        Problem450 p = new Problem450();
        TreeNode res = p.deleteNode(n1, 3);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.left != null){
                TreeNode max = findMax(root.left);
                root.val = max.val;
                root.left = deleteNode(root.left, max.val);
            } else {
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }


    public TreeNode findMax(TreeNode root) {
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    public TreeNode findMin(TreeNode root) {
        TreeNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
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