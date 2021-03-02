package com.kangjiaqi.leetcode.problem1644;

import java.util.ArrayList;
import java.util.List;

public class Problem1644 {
    public List<TreeNode> ancestors = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int n = cntNodes(root, p, q);
        if (n != 2) return null;
        return ancestors.get(0);
    }

    public int cntNodes(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left = cntNodes(root.left, p, q);
        int right = cntNodes(root.right, p, q);
        int curNum = (root == p || root == q) ? left + right + 1 : left + right;
        if(curNum == 2) ancestors.add(root);
        return curNum;
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
