package com.kangjiaqi.leetcode.problem1457;

import java.util.ArrayList;
import java.util.List;

public class Problem1457 {
    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root, new int[9]);
        return result;
    }

    public void dfs(TreeNode root, int[] numCnt) {
        if (root == null) return;
        numCnt[root.val - 1]++;
        if (isLeaf(root)) {
            if (isPseudoPalind(numCnt)) result++;
        }
        dfs(root.left, numCnt);
        dfs(root.right, numCnt);
        numCnt[root.val - 1]--;
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public boolean isPseudoPalind(int[] numCnt) {
        int oddNum = 0;
        for (int i = 0; i < 9; ++i) {
            if (numCnt[i] % 2 != 0) oddNum++;
            if(oddNum > 1) return false;
        }
        return true;
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