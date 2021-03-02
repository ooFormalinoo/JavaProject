package com.kangjiaqi.leetcode.problem_broadview37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_broadview37 {
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        List<String> l = new ArrayList<>(Arrays.asList(s));
        return helper(l);
    }
    public TreeNode helper(List<String> l) {
        if(l.get(0).equals("#")) {
            l.remove(0);
            return null;
        }
        int curVal = Integer.parseInt(l.get(0));
        l.remove(0);
        TreeNode root = new TreeNode(curVal);
        root.left = helper(l);
        root.right = helper(l);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
