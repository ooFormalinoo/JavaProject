package com.kangjiaqi.leetcode.problem105;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;
        int curVal = preorder[preL];
        int inIdx = getIndex(inorder, curVal);
        TreeNode root = new TreeNode(curVal);
        int subLenLeft = inIdx - inL;
        root.left = helper(preorder, inorder, preL + 1, preL + subLenLeft, inL, inIdx - 1);
        root.right = helper(preorder, inorder, preL + subLenLeft + 1, preR, inIdx + 1, inR);
        return root;
    }

    public int getIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
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