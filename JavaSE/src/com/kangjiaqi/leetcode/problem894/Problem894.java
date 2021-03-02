package com.kangjiaqi.leetcode.problem894;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem894 {
    public Map<Integer, List<TreeNode>> mem = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N % 2 == 0) return result;
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = null;
            List<TreeNode> right = null;
            if(mem.containsKey(i)) {
                left = mem.get(i);
            } else {
                left = allPossibleFBT(i);
                mem.put(i, left);
            }
            if(mem.containsKey(N-1-i)) {
                right = mem.get(N-1-i);
            } else {
                right = allPossibleFBT(N - 1 - i);
                mem.put(N-1 - i, right);
            }
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
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