package com.kangjiaqi.leetcode.problem1145;

public class Problem1145 {
    class Result {
        public int num;
        public boolean legal;

        public Result(int num, boolean legal) {
            this.num = num;
            this.legal = legal;
        }
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Result result = helper(root, n, x);
        return result.legal;
    }

    public Result helper(TreeNode root, int n, int x) {
        if (root == null) return new Result(0, false);
        Result left = helper(root.left, n, x);
        Result right = helper(root.right, n, x);
        boolean curLegal = false;
        if (root.val == x) {
            curLegal = left.num > n / 2 ||
                    right.num > n / 2 ||
                    (n - left.num - right.num - 1) > n / 2;
        }
        return new Result(left.num + right.num + 1, curLegal || left.legal || right.legal);
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