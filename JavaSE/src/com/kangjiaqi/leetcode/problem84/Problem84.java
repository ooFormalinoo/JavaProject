package com.kangjiaqi.leetcode.problem84;

import java.util.Stack;

public class Problem84 {
    public static void main(String[] args) {
        Problem84 p = new Problem84();
        int[] nums = {2,1,5,6,2,3};
        int result = p.largestRectangleArea(nums);
        System.out.println(result);
    }
    public int largestRectangleArea(int[] heights) {
        int result = -1;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(-1, -1));
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? -1 :heights[i];
            while (!stack.empty() && stack.peek().height > curHeight) {
                Node curNode = stack.pop();
                int width = i - stack.peek().idx - 1;
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
