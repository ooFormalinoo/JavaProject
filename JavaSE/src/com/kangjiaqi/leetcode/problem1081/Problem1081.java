package com.kangjiaqi.leetcode.problem1081;
/*
* Given a string s, remove duplicate letters so that every letter appears once and only once.
* You must make sure your result is the smallest in lexicographical order among all possible results.
* */


/*
* example1
* Input s = "bcabc"
* Output: "abc"
*
* example2
* Input s = "cbacdcbc"
* Output: "acdb"
* */

public class Problem1081 {
    public static void main(String[] args) {
        Problem1081 problem = new Problem1081();
        String s = "bbac";
        String result = problem.removeDuplicateLetters(s);
        System.out.println(result);
    }
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] exists = new boolean[26];
        int[] lettersCnt = new int[26];
        for(int i = 0; i < n; i++) {
            char curLetter = s.charAt(i);
            lettersCnt[curLetter - 'a']++;
        }
        StringBuilder result = new StringBuilder(10000);
        for(int i = 0; i < n; i++) {
            char curLetter = s.charAt(i);
            if(exists[curLetter - 'a']){
                lettersCnt[curLetter - 'a'] -= 1;
                continue;
            }
            else{
                while(result.length()>0 && result.charAt(result.length()-1) > curLetter) {
                    char lastLetter = result.charAt(result.length()-1);
                    if(lettersCnt[lastLetter - 'a'] > 0){
                        result.deleteCharAt(result.length() - 1);
                        exists[lastLetter - 'a'] = false;
                    }
                    else{
                        break;
                    }
                }
                result.append(curLetter);
                exists[curLetter - 'a'] = true;
            }
            lettersCnt[curLetter - 'a'] -= 1;

        }
        return result.toString();
    }
}
