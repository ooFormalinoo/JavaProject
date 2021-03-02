package com.kangjiaqi.leetcode.problem402;

public class Problem402 {
    public static void main(String[] args) {
        Problem402 p = new Problem402();
        String s = "112";
        String result = p.removeKdigits(s, 1);
        System.out.println(result);
    }
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder(10002);
        int n = num.length();
        int dropNum = 0;
        for (int i = 0; i < n; i++) {
            char curNum = num.charAt(i);
            while (dropNum < k && result.length() > 0 && result.charAt(result.length() - 1) > curNum) {
                result.deleteCharAt(result.length() - 1);
                dropNum++;
            }
            result.append(curNum);
        }
        while (result.length() > 0 && result.charAt(0) =='0') {
            result.deleteCharAt(0);
        }
        if (result.length() == 0) {
            return "0";
        }
        if (dropNum < k) {
            for(int i = 0; i < k - dropNum; i++) {
                result.deleteCharAt(result.length() - 1);
            }
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}
