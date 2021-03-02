package com.kangjiaqi.leetcode.problem103;

import java.util.*;

public class Problem103 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;

        Problem103 p = new Problem103();
        List<List<Integer>> result = new ArrayList<>();
        result = p.zigzagLevelOrder(n1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrder(root, result);
        return result;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;

        queue.add(root);
        int flag = 1;

        while (!queue.isEmpty()) {
            Deque<Integer> curLayer = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
                if(flag == 1)
                    curLayer.addLast(curNode.val);
                else
                    curLayer.addFirst(curNode.val);
            }
            result.add(new LinkedList<Integer>(curLayer));
            flag = -flag;
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
