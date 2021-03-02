package com.kangjiaqi.leetcode.problem95;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {
    public static void main(String[] args) {
        Problem95 p = new Problem95();
        List<TreeNode> result = p.generateTrees(3);
        System.out.println(result.size());
    }
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    public List<TreeNode> helper(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if(left > right) {
            result.add(null);
            return result;
        }
        if(left == right) {
            result.add(new TreeNode(left));
            return result;
        }

        for(int root = left; root <= right; root++) {
            List<TreeNode> leftSubtree = helper(left, root - 1);
            List<TreeNode> rightSubtree = helper(root + 1, right);
            for(TreeNode l:leftSubtree) {
                for(TreeNode r:rightSubtree) {
                    result.add(new TreeNode(root, l, r));
                }
            }
        }
        return result;
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