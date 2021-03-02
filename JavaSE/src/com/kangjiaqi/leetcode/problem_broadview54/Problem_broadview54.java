package com.kangjiaqi.leetcode.problem_broadview54;

public class Problem_broadview54 {
    public int result;
    public int count;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        Problem_broadview54 p = new Problem_broadview54();
        int result = p.kthLargest(root, 1);
        System.out.println(result);
    }
    public int kthLargest(TreeNode root, int k) {
        postorder(root, k);
        return result;
    }
    public void postorder(TreeNode root, int k) {
        if (root == null) return;
        postorder(root.right, k);
        count++;
        if(k == count){
            result = root.val;
            return;
        }
        postorder(root.left, k);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
