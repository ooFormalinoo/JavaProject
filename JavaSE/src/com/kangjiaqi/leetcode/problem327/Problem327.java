package com.kangjiaqi.leetcode.problem327;

public class Problem327 {
    public static void main(String[] args) {
        Problem327 p = new Problem327();
        int result = p.countRangeSum(new int[] {0, 2, 0, -1, 1, -3, -2}, 3, 7);
        System.out.println(result);
//        AVLTree tree = new AVLTree();
//        int[] values = new int[]{9, 1, 23, 1, 2, 3, 4, 5};
//        for (int v : values) {
//            tree.insertVal(v);
//        }
//        System.out.println(tree.cntNodes(1, 9));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;
        if (nums.length == 0 || lower > upper) return result;
        long lastSum = 0;
        AVLTree tree = new AVLTree();
        tree.insertVal(lastSum);
        for (int j = 0; j < nums.length; j++) {
            long curSum = lastSum + nums[j];
            result += tree.cntNodes(curSum - upper, curSum - lower);

            lastSum = curSum;
            tree.insertVal(curSum);
        }
        return result;
    }
}

class Node {
    public long val;
    public int height;
    public int count;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(long val, int height) {
        this.val = val;
        this.height = height;
        this.count = 1;
    }
}

class AVLTree {
    public Node root;

    private int getHeight(Node root) {
        return root == null ? 0 : root.height;
    }

    private int getBalance(Node root) {
        return root == null ? 0 : getHeight(root.left) - getHeight(root.right);
    }

    private Node leftLeftRotation(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }

    private Node rightRightRotation(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }

    private Node leftRightRotation(Node root) {
        root.left = rightRightRotation(root.left);
        return leftLeftRotation(root);
    }

    private Node rightLeftRotation(Node root) {
        root.right = leftLeftRotation(root.right);
        return rightRightRotation(root);
    }

    private Node insert(Node root, long val) {
        if (root == null) return new Node(val, 1);
        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.count++;
            return root;
        }
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int balance = getBalance(root);
        if (balance == 2 && val < root.left.val) {
            return leftLeftRotation(root);
        }
        if (balance == 2 && val > root.left.val) {
            return leftRightRotation(root);
        }
        if (balance == -2 && val > root.right.val) {
            return rightRightRotation(root);
        }
        if (balance == -2 && val < root.right.val) {
            return rightLeftRotation(root);
        }
        return root;
    }

    public void insertVal(long val) {
        this.root = insert(this.root, val);
    }

    private int cnt(Node root, long low, long high) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= low && root.val <= high) {
            res += root.count;
            res += cnt(root.left, low, high);
            res += cnt(root.right, low, high);
        } else if (root.val < low) {
            res += cnt(root.right, low, high);
        } else {
            res += cnt(root.left, low, high);
        }
        return res;
    }

    public int cntNodes(long low, long high) {
        return cnt(this.root, low, high);
    }
}