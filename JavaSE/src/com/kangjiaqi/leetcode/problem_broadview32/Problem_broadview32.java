package com.kangjiaqi.leetcode.problem_broadview32;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_broadview32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curLayer = new LinkedList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                curLayer.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(curLayer);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}