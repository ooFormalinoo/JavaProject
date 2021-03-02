package com.kangjiaqi.leetcode.problem_inter1005;

public class Problem_inter1005 {
    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mid;
            while(mid >= left && words[mid].equals("")) {
                --mid;
            }
            if(mid == left - 1) {
                left = temp + 1;
                continue;
            }
            if(words[mid].equals(s)) {
                return mid;
            } else if(words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else if(words[mid].compareTo(s) > 0) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
