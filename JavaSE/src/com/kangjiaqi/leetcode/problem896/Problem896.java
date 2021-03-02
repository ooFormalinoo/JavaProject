package com.kangjiaqi.leetcode.problem896;

public class Problem896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        int flag = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            if (diff == 0) {
                continue;
            } else {
                if(diff * flag >= 0) {
                    flag = diff;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
