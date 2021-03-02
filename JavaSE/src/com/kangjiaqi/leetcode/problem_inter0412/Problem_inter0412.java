package com.kangjiaqi.leetcode.problem_inter0412;

public class Problem_inter0412 {
    public int result = 0;

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(-2);
        n1.right = new TreeNode(-3);
        n1.left.left = new TreeNode(1);
        n1.left.right = new TreeNode(3);
        n1.left.left.left = new TreeNode(-1);
        n1.right.left = new TreeNode(-2);

        Problem_inter0412 p = new Problem_inter0412();
        int n = p.pathSum(n1, -1);
        System.out.println(n);
    }
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }
    public void helper(TreeNode root, int sum, int curSum) {
        if (root == null) return;
        if(curSum + root.val == sum) {
            result += 1;
        }
        helper(root.left, sum, curSum + root.val);
        helper(root.right, sum, curSum + root.val);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}