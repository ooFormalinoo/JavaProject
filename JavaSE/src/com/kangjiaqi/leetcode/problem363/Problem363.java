package com.kangjiaqi.leetcode.problem363;

import java.util.Set;
import java.util.TreeSet;

public class Problem363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] preSum = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                preSum[i][j] = j == 0 ? matrix[i][j] : matrix[i][j] + preSum[i][j - 1];
            }
        }
        for (int right = 0; right < N; right++) {
            for (int left = -1; left < right; left++) {
                int[] nums = new int[M];
                for (int m = 0; m < M; m++) {
                    nums[m] = left == -1 ? preSum[m][right] : preSum[m][right] - preSum[m][left];
                }
                int temp = maxSumSubarray(nums, k);
                if (temp <= k) {
                    result = Math.max(result, temp);
                }
            }
        }
        return result;
    }

    public int maxSumSubarray(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        int[] preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = (i == 0 ? nums[i] : nums[i] + preSum[i - 1]);
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int j = 0; j < preSum.length; j++) {
            Integer curJ = preSum[j];
            Integer curI = set.ceiling(curJ - k);
            if (curI != null)
                result = Math.max(result, curJ - curI);
            set.add(curJ);
        }
        return result;
    }
}

//class BSTree {
//
//    class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node() {
//        }
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//
//    private Node root;
//
//    private Node insert(Node root, int val) {
//        if (root == null) return new Node(val);
//        if (val < root.val) {
//            root.left = insert(root.left, val);
//        } else if (val > root.val) {
//            root.right = insert(root.right, val);
//        }
//        return root;
//    }
//
//    public void insert(int val) {
//        this.root = insert(this.root, val);
//    }
//
//    // 寻找BST中比target大的最小值
//    public int find(int target) {
//        int result = Integer.MAX_VALUE;
//        Node curNode = this.root;
//        while (curNode != null) {
//            if (curNode.val >= target) {
//                result = curNode.val;
//                curNode = curNode.left;
//            } else {
//                curNode = curNode.right;
//            }
//        }
//        return result;
//    }
//}
