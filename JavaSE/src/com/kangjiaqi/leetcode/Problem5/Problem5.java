package com.kangjiaqi.leetcode.Problem5;

/*Given a string s, return the longest palindromic substring in s*/

/*还有一种中心扩散方法*/

public class Problem5 {
    public static void main(String[] args) {
        Problem5 p = new Problem5();
        String s = "babad";
        System.out.println(p.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        //dp[i][j]表示以i开头j结尾的字串是否为回文串
        boolean[][] dp = new boolean[n][n];
        //边界条件，长度=1和2的字串的判断
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            if (i < n - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        //按字串的长度枚举，从长度为3开始
        for (int l = 3; l <= n; ++l) {
            //枚举字串的左端点
            for (int i = 0; i + l - 1 < n; ++i) {
                int j = i + l - 1; //字串的右端点
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        int max = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i<n; ++i) {
            for (int j = i; j < n; ++j){
                if (dp[i][j] && j-i+1>max){
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
