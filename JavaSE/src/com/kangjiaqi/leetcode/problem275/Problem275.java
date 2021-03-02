package com.kangjiaqi.leetcode.problem275;

public class Problem275 {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int n = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(citations[n - 1 -mid] == mid + 1){
                left = mid + 1;
            } else if(citations[n - 1 -mid] < mid + 1){
                right = mid - 1;
            } else if(citations[n - 1 -mid] > mid + 1){
                left = mid + 1;
            }
        }
        return left;
    }
}
