package com.kangjiaqi.leetcode.problem865;

import java.util.*;

public class Problem865 {
    List<TreeNode> resNode = new ArrayList<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashSet<TreeNode> deepestNodes = levelOrder(root);
        int i = cntDeepest(root, deepestNodes);
        return resNode.get(0);
    }
    public int cntDeepest(TreeNode root, HashSet<TreeNode> deepestNodes){
        if(root == null) return 0;
        int left = cntDeepest(root.left, deepestNodes);
        int right = cntDeepest(root.right, deepestNodes);
        int res = left + right;
        if(deepestNodes.contains(root)){
            ++res;
        }
        if(res == deepestNodes.size()){
            resNode.add(root);
        }
        return res;
    }
    public HashSet<TreeNode> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> deepestNodes = new HashSet<>();
        if (root == null) return deepestNodes;

        queue.add(root);

        while(!queue.isEmpty()){
            deepestNodes.clear();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                deepestNodes.add(curNode);
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
        }
        return deepestNodes;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
