package com.kangjiaqi.leetcode.problem897;

import java.util.ArrayList;
import java.util.List;

public class Problem897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        TreeNode head = null, tail = null;
        head = tail = new TreeNode(nums.get(0));
        for(int i = 1; i < nums.size(); i++){
            tail.right = new TreeNode(nums.get(i));
            tail = tail.right;
        }
        return head;
    }
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
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