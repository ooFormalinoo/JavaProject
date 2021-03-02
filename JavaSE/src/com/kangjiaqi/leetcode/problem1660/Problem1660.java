package com.kangjiaqi.leetcode.problem1660;

import java.util.HashMap;
import java.util.Map;

public class Problem1660 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;
        n2.right = n3;

        Problem1660 p = new Problem1660();
        TreeNode root = p.correctBinaryTree(n1);
        System.out.println(root);
    }
    public TreeNode node = null;
    public TreeNode correctBinaryTree(TreeNode root) {
        Map<TreeNode, TreeNode> cnt = new HashMap<>();
        cntParent(root, null, cnt);
        TreeNode parent = cnt.get(this.node);
        if(parent.left == node) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        return root;
    }
    public void cntParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> cnt) {
        if (root == null) return;
        if(cnt.containsKey(root)) {
            if(cnt.get(root) != parent) {
                node = cnt.get(root);
                return;
            }
        }else {
            cnt.put(root, parent);
        }
        cntParent(root.left, root, cnt);
        cntParent(root.right, root, cnt);
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