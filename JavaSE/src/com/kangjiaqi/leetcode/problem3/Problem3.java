package com.kangjiaqi.leetcode.problem3;
/*Given a string s, find the length of the longest substring without repeating characters.*/

import java.util.HashMap;

public class Problem3 {
    public static void main(String[] args) {
        Problem3 p = new Problem3();
        String s = "bbbbb";
        System.out.println(p.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        // 动态规划，数组表示的以第i个字符结尾的最大长度
        int[] maxLenEndWith = new int[n];
        HashMap<Character, Integer> lastPosOf = new HashMap<>();

        // init
        maxLenEndWith[0] = 1;
        lastPosOf.put(s.charAt(0), 0);

        for (int i = 1; i < n; ++i) {
            char curChar = s.charAt(i);
            int start = i - maxLenEndWith[i - 1];
            if (lastPosOf.containsKey(curChar) && lastPosOf.get(curChar) >= start) {
                maxLenEndWith[i] = i - lastPosOf.get(curChar);
                lastPosOf.put(curChar, i);
            } else {
                maxLenEndWith[i] = maxLenEndWith[i - 1] + 1;
                lastPosOf.put(curChar, i);
            }
        }
        int max = 0;
        for(int i = 0; i < n; ++i){
            if(maxLenEndWith[i] > max){
                max = maxLenEndWith[i];
            }
        }
        return max;
    }
}
