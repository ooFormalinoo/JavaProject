package com.kangjiaqi.leetcode.problem778;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem778 {
    class Node {
        public int i;
        public int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int swimInWater(int[][] grid) {
        int left = 0;
        int right = grid.length * grid.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(check(mid, grid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return Math.max(left, grid[0][0]);
    }
    public boolean check(int threshold, int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        Arrays.fill(visited, false);
        Queue<Node> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new Node(0, 0));

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            for(int[] d:directions) {
                int newI = curNode.i + d[0];
                int newJ = curNode.j + d[1];
                if(newI >=0 && newI <grid.length && newJ >=0 && newJ < grid.length) {
                    if(!visited[newI][newJ] && grid[newI][newJ] <= threshold) {
                        queue.add(new Node(newI, newJ));
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
        return visited[grid.length-1][grid.length-1];
    }
}
