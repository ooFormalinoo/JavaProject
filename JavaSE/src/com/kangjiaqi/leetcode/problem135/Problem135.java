package com.kangjiaqi.leetcode.problem135;
/*There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *
 *    Each child must have at least one candy.
 *    Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * */

/*
 * example1
 * input: [1,0,2]
 * output: 5
 *
 * example2
 * input: [1,2,2]
 * output: 4*/

import java.util.Arrays;

public class Problem135 {
    public static void main(String[] args) {
        Problem135 p = new Problem135();
        int[] ratings = {1, 3, 2, 2, 1};
        int result = p.candy(ratings);
        System.out.println(result);
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 1; i < n; i++) {
            ans[i] = (ratings[i] > ratings[i - 1]) ? ans[i - 1] + 1 : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = (ratings[i] > ratings[i + 1]) ? Math.max(ans[i], ans[i + 1] + 1) : ans[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ans[i];
        }
        return sum;

    }
}
