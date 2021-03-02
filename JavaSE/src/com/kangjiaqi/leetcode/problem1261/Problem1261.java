package com.kangjiaqi.leetcode.problem1261;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem1261 {
    public Map<Integer, Boolean> exists = new HashMap<>();
    public Problem1261(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        root.val = 0;
        exists.put(0, true);
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.push(curNode);
                if (curNode.left != null) {
                    curNode.left.val = curNode.val * 2 + 1;
                    exists.put(curNode.left.val, true);
                }
                if (curNode.right != null) {
                    curNode.right.val = curNode.val * 2 + 2;
                    exists.put(curNode.right.val, true);
                }
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
    }


    public boolean find(int target) {
        return exists.containsKey(target);
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