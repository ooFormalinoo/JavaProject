package com.kangjiaqi.leetcode.problem1339;

import java.util.ArrayList;
import java.util.List;

public class Problem1339 {
    public int maxProduct(TreeNode root) {
        long res = 0;
        long c = (long)Math.pow(10, 9) + 7;
        List<Long> sum = new ArrayList<>();
        long totalSum = cntSum(root, sum);
        for (int i = 0; i < sum.size() - 1; i++) {
            long temp1 = totalSum - sum.get(i);
            long tmp_res = sum.get(i) * temp1;
            if(tmp_res > res) res = tmp_res;
        }
        return (int)(res % c);
    }

    public long cntSum(TreeNode root, List<Long> sum) {
        if (root == null) return 0;
        long curSum = cntSum(root.left, sum) + cntSum(root.right, sum) + root.val;
        sum.add(curSum);
        return curSum;
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