package com.kangjiaqi.leetcode.problem_broadview26;

public class Problem_broadview26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSub(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        return a.val == b.val && isSub(a.left, b.left) && isSub(a.right, b.right);
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
