package com.kangjiaqi.leetcode.problem272;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem272 {
    class Pair implements Comparable<Pair> {
        public double val;
        public double diff;

        public Pair(double val, double diff) {
            this.val = val;
            this.diff = diff;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.diff, this.diff);
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        preOrder(root, target, k, queue);
        ArrayList<Integer> result = new ArrayList<>();
        for(Pair p:queue) {
            result.add((int)p.val);
        }
        return result;
    }

    public void preOrder(TreeNode root, double target, int k, PriorityQueue<Pair> result) {
        if (root == null) return;
        double curDiff = Math.abs(root.val - target);
        if (result.size() < k) {
            result.add(new Pair(root.val, curDiff));
        } else {
            Pair curPair = result.poll();
            if (curPair.diff < curDiff) result.add(curPair);
            else result.add(new Pair(root.val, curDiff));
        }
        preOrder(root.left, target, k, result);
        preOrder(root.right, target, k, result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}