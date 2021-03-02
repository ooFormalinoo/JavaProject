package com.kangjiaqi.leetcode.problem454;

import java.util.HashMap;
import java.util.Map;

public class Problem454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> sumAB = new HashMap<Integer, Integer>();
        for (int a : A) {
            for (int b : B) {
                sumAB.merge(a + b, 1, Integer::sum);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (sumAB.containsKey(-c - d)) {
                    result += sumAB.get(-c - d);
                }
            }
        }
        return result;
    }
}
