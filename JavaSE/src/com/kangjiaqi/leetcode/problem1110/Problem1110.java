package com.kangjiaqi.leetcode.problem1110;

import java.util.*;

public class Problem1110 {
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delArray = new HashSet<>();
        for (Integer i : to_delete) {
            delArray.add(i);
        }
        TreeNode fakeParent = new TreeNode(-1);
        fakeParent.left = root;
        del(root, fakeParent, delArray);
        if (fakeParent.left != null) res.add(root);
        return res;
    }

    public void del(TreeNode root, TreeNode parent, Set<Integer> to_delete) {
        if (root == null) {
            return;
        }
        del(root.left, root, to_delete);
        del(root.right, root, to_delete);
        if (to_delete.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            if (parent.left == root)
                parent.left = null;
            else
                parent.right = null;

        }
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