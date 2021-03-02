package com.kangjiaqi.leetcode.problem1530;

import java.util.ArrayList;
import java.util.List;

public class Problem1530 {
    public List<Integer> leaves = new ArrayList<>();

    public static void main(String[] args) {
    }

    public int countPairs(TreeNode root, int distance) {
        Pair p = helper(root, distance);
        return p.cnt;
    }

    public Pair helper(TreeNode root, int distance) {
    /*递归函数返回的是以root为最近公共祖先的叶子节点对的数目，既然两个叶子节点a和p以root为最近公共祖先，因此a和b一定分别在root的两侧，因此求出
    * 左子树中所有叶子节点到root的距离以及右子树中到root的距离，左边一个右边一个记录满足要求的节点对的数目，即为以root为最近公共祖先的好叶子节点
    * 对的数目，该数目再递归加上以root.left为最近祖先的节点对数目以及以root.right为最近祖先的节点对的数目，就是整个树的结果*/
        if(root == null) {
            return new Pair(new int[distance + 1], 0);
        }
        if (isLeaf(root)) {
            int[] depth = new int[distance + 1];
            depth[0] = 1;
            return new Pair(depth, 0);
        }
        int[] leftDepth = new int[distance + 1];
        int[] rightDepth = new int[distance + 1];
        int leftCnt = 0, rightCnt = 0;

        Pair leftP = helper(root.left, distance);
        leftDepth = leftP.depth;
        leftCnt = leftP.cnt;

        Pair rightP = helper(root.right, distance);
        rightDepth = rightP.depth;
        rightCnt = rightP.cnt;

        int cnt = leftCnt + rightCnt;
        int[] depth = new int[distance + 1];

        for (int i = 0; i < distance; ++i) {
            depth[i + 1] = leftDepth[i] + rightDepth[i];
        }
        for (int i = 0; i <= distance; ++i) {
            for (int j = 0; j <= distance; ++j) {
                if (i + j + 2 <= distance) {
                    cnt = leftDepth[i] * rightDepth[j] + cnt;
                }
            }
        }
        return new Pair(depth, cnt);
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

class Pair {
    // 因为函数的返回值有两个，所以自定义一个类包含这两个返回值
    // 以root为最近公共父节点的叶子节点之间的最短距离是两个叶子到root之间的距离之和，为了获取距离小于distance的，所以depth只需记录到root节点
    // 的距离小于等于distance的即可
    public int[] depth; //depth[i]表示到当前root节点距离为i的叶子节点的个数
    public int cnt; //depth[i]表示当前root节点下输所有“好叶子节点对”的数目

    public Pair(int[] depth, int cnt) {
        this.depth = depth;
        this.cnt = cnt;
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