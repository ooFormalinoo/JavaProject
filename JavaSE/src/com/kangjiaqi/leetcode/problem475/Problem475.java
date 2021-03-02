package com.kangjiaqi.leetcode.problem475;

import java.util.TreeSet;

public class Problem475 {
    public static void main(String[] args) {
        Problem475 p = new Problem475();
        int[] houses = {1, 5};
        int[] heaters = {10};
        int result = p.findRadius(houses, heaters);
        System.out.println(result);
    }
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int h : heaters) set.add(h);

        // 保证所有的hourse都有left和right
        for (int i = 0; i < houses.length; i++) {
            int curHouse = houses[i];
            Integer left = set.floor(curHouse);
            Integer right = set.ceiling(curHouse);
            int curR;
            if(left == null) curR = right - curHouse;
            else if(right == null) curR = curHouse - left;
            else curR = Math.min(curHouse - left, right - curHouse);
            result = Math.max(result, curR);
        }
        return result;
    }
}
