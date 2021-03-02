package com.kangjiaqi.leetcode.problem530;

import java.util.ArrayList;
import java.util.List;

public class Problem530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        inOrder(root, l);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l.size() - 1; i++) {
            if(l.get(i + 1) - l.get(i) < min) {
                min = l.get(i + 1) - l.get(i);
            }
        }
        return min;
    }
    public void inOrder(TreeNode root, List<Integer> l) {
        if(root == null) return;
        inOrder(root.left, l);
        l.add(root.val);
        inOrder(root.right, l);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}