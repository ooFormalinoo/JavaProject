package com.kangjiaqi.leetcode.problem366;

import java.util.ArrayList;
import java.util.List;

public class Problem366 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        int n = dfs(root);
        return result;
    }

    int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int curDepth = Math.max(left, right) + 1;
        if (curDepth >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(curDepth).add(root.val);
        return curDepth;
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
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