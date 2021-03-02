package com.kangjiaqi.leetcode.problem663;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem663 {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, ArrayList<TreeNode>> nodeOf = new HashMap<>();
        int totalSum = sum(root, nodeOf);
        if (totalSum % 2 != 0) return false;
        int halfVal = totalSum / 2;
        return nodeOf.containsKey(halfVal) && nodeOf.get(halfVal).get(0) != root;
    }

    public int sum(TreeNode root, Map<Integer, ArrayList<TreeNode>> nodeOf) {
        if (root == null) return 0;
        int curSum = root.val + sum(root.left, nodeOf) + sum(root.right, nodeOf);
        if (!nodeOf.containsKey(curSum)) {
            nodeOf.put(curSum, new ArrayList<>());
        }
        nodeOf.get(curSum).add(root);
        return curSum;
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