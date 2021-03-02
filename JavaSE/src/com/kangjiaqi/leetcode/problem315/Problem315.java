package com.kangjiaqi.leetcode.problem315;

import java.util.*;

public class Problem315 {
    public static void main(String[] args) {
        int[] nums = {9, 8, 1, 2, 2, 5, 7, 6, 3, 3};
        Node root = null;
        for (int i : nums) {
            root = AVLTree.insert(root, i);
        }
        System.out.println(root);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Node root = null;
        for (int i = nums.length - 1; i >= 0; --i) {
           result.add(AVLTree.findAndCount(root, nums[i]));
           root = AVLTree.insert(root, nums[i]);
        }
        Collections.reverse(result);
        return result;
    }
}

class AVLTree {
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.leftNodes++;
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            root.count++;
        }
        int balance = getBalance(root);
        if (balance == 2 && val < root.left.val) {
            return leftLeftRotate(root);
        }
        if (balance == 2 && val >= root.left.val) {
            return leftRightRotate(root);
        }
        if (balance == -2 && val < root.right.val) {
            return rightLeftRotate(root);
        }
        if (balance == -2 && val >= root.right.val) {
            return rightRightRotate(root);
        }
        return root;
    }

    public static int findAndCount(Node root, int target) {
        Node curNode = root;
        int result = 0;
        while (curNode != null) {
            if (target == curNode.val) {
                result += curNode.leftNodes;
                break;
            } else if (target > curNode.val) {
                result = result + curNode.leftNodes + curNode.count;
                curNode = curNode.right;
            } else {
                curNode = curNode.left;
            }
        }
        return result;
    }

    private static Node rightLeftRotate(Node root) {
        root.right = leftLeftRotate(root.right);
        return rightRightRotate(root);
    }

    private static Node leftRightRotate(Node root) {
        root.left = rightRightRotate(root.left);
        return leftLeftRotate(root);
    }

    private static Node rightRightRotate(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        temp.leftNodes = temp.leftNodes + root.count + root.leftNodes;
        return temp;
    }

    private static Node leftLeftRotate(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        root.leftNodes = root.leftNodes - temp.leftNodes - temp.count;
        temp.right = root;
        return temp;
    }

    private static int getBalance(Node root) {
        return root == null ? 0 : getHeight(root.left) - getHeight(root.right);
    }

    private static int getHeight(Node root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

class Node {
    int val;
    int count;
    int leftNodes;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.count = 1;
    }
}
