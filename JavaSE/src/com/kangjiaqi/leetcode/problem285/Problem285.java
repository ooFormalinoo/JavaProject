package com.kangjiaqi.leetcode.problem285;

import java.util.Stack;

public class Problem285 {
    public TreeNode result = null;

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        Problem285 p = new Problem285();
        TreeNode t = p.inorderSuccessor(n1, n2);
        System.out.println(t.val);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return null;
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()) {
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if(!stack.isEmpty()) {
                curNode = stack.pop();
                if(flag) {
                    return curNode;
                }
                if(curNode == p) {
                    flag = true;
                }
                curNode = curNode.right;
            }
        }
        return null;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}