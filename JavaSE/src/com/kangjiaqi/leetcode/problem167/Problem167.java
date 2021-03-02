package com.kangjiaqi.leetcode.problem167;

import java.util.Arrays;

public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; ++i) {
            int k = binSearch(numbers, i, target);
            if(k != -1) {
                res[0] = i + 1;
                res[1] = k + 1;
                Arrays.sort(res);
            }
        }
        return res;
    }

    public int binSearch(int[] numbers, int curPos, int target) {
        int left = curPos + 1;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] + numbers[curPos] == target) {
                if (mid != target) return mid;
                else return -1;
            } else if (numbers[mid] + numbers[curPos] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
