package com.kangjiaqi.leetcode.problem_broadview28;

public class Problem_broadview28 {
    public boolean isSymmetric(TreeNode root) {
        return preOrder(root).equals(postOrder(root));
    }
    public String preOrder(TreeNode root){
        if(root==null) return "#";
        return  preOrder(root.left) + root.val + preOrder(root.right);
    }
    public String postOrder(TreeNode root){
        if(root==null) return "#";
        return  postOrder(root.right) + root.val + postOrder(root.left);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}