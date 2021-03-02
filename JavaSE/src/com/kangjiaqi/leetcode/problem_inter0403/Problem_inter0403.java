package com.kangjiaqi.leetcode.problem_inter0403;


import java.util.LinkedList;
import java.util.Queue;

public class Problem_inter0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree==null) return null;

        int depth = getDepth(tree);
        ListNode[] result = new ListNode[depth];
        int layerNum = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tree);

        while(!q.isEmpty()) {
            int size = q.size();
            ListNode head = null, tail = null;
            for(int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if(head==null){
                    head = tail = new ListNode(curNode.val);
                } else {
                    tail.next = new ListNode(curNode.val);
                    tail = tail.next;
                }
                if(curNode.left != null){
                    q.offer(curNode.left);
                }
                if(curNode.right != null){
                    q.offer(curNode.right);
                }
            }
            result[layerNum++] = head;
        }
        return result;
    }
    public int getDepth(TreeNode tree) {
        if (tree == null)
            return 0;
        else
            return Math.max(getDepth(tree.left), getDepth(tree.right)) + 1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}