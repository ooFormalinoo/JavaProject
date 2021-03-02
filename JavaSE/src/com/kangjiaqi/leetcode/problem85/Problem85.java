package com.kangjiaqi.leetcode.problem85;


import java.util.Arrays;
import java.util.Stack;

public class Problem85 {
    public static void main(String[] args) {
        Problem85 p = new Problem85();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int result = p.maximalRectangle(matrix);
        System.out.println(result);
    }

    public int maximalRectangle(char[][] matrix) {
        int result = -1;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[] curHeights = new int[n];
        Arrays.fill(curHeights, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curHeights[j] = matrix[i][j] == '0' ? 0 : curHeights[j] + matrix[i][j] - '0';
            }
            result = Math.max(result, maxHelper(curHeights));
        }
        return result;
    }

    public int maxHelper(int[] heights) {
        int result = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(-1, -1));
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && stack.peek().height > curHeight) {
                Node curNode = stack.pop();
                int width = i - 1 - stack.peek().idx;
                result = Math.max(result, width * curNode.height);
            }
            stack.push(new Node(i, curHeight));
        }
        return result;
    }
}

class Node {
    int idx;
    int height;

    public Node() {
    }

    public Node(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

