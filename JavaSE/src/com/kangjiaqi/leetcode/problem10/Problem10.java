package com.kangjiaqi.leetcode.problem10;

import java.util.HashMap;
import java.util.Map;

public class Problem10 {
    public static void main(String[] args) {
        Problem10 p = new Problem10();
        String s = "aaa";
        String b = "ab*a*c*a";
        boolean result = p.isMatch(s, b);
        System.out.println(result);
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        boolean firstMatch = s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
