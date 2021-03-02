package com.kangjiaqi.leetcode.problem230;

import java.util.Stack;

public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        int cnt = 0;
        while (curNode != null || !stack.isEmpty()) {
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if(!stack.isEmpty()) {
                curNode = stack.pop();
                if(++cnt == k) return curNode.val;
                curNode = curNode.right;
            }
        }
        return -1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
