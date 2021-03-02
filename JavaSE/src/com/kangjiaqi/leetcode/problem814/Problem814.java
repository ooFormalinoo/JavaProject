package com.kangjiaqi.leetcode.problem814;

public class Problem814 {
    public static void main(String[] args) {
        Problem814 p = new Problem814();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(contains(root)){
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }else{
            return null;
        }
        return root;
    }
    public boolean contains(TreeNode root){
        if (root == null) return false;
        return (root.val == 1) || contains(root.left) || contains(root.right);
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
