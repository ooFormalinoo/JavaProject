package com.kangjiaqi.leetcode.problem1649;

import java.util.*;

public class Problem1649 {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(1);
        Problem1649 p = new Problem1649();
        int[] arr = {1, 5, 6, 2, 4};
        int result = p.createSortedArray(arr);
    }

    public int createSortedArray(int[] instructions) {
        long cost = 0;
        List<Integer> nums = new LinkedList<>();
        int[] numCnt = new int[100001];
        for (int cur : instructions) {
            if(nums.size() == 0) {
                nums.add(cur);
                numCnt[cur]++;
                continue;
            }
            int leftBound = leftBound(nums, cur);
            int leftCost = 0, rightCost = 0;
            for (int i = 0; i < leftBound; i++) {
                leftCost += numCnt[nums.get(i)];
            }
            for (int i = numCnt[cur] == 0 ? leftBound : leftBound + 1; i <nums.size(); i++) {
                rightCost += numCnt[nums.get(i)];
            }
            cost = cost + Math.min(leftCost, rightCost);
            if (numCnt[cur] == 0) {
                nums.add(leftBound, cur);
            }
            numCnt[cur]++;
        }
        return (int) (cost % (10e7 + 9));
    }

    public int leftBound(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                right = mid - 1;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
