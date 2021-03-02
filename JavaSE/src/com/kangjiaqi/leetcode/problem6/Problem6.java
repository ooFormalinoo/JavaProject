package com.kangjiaqi.leetcode.problem6;
/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * */

public class Problem6 {
    public static void main(String[] args) {
        Problem6 p = new Problem6();
        String s = "PAYPALISHIRING";
        System.out.println(p.convert(s, 3));
    }
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n == 1 || numRows == 1) return s;
        StringBuilder[] zigzag = new StringBuilder[numRows];
        for (int i = 0; i<numRows; ++i) {
            zigzag[i] = new StringBuilder();
        }
        int rowIndex = 0;
        int step = -1;
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            zigzag[rowIndex].append(curChar);
            if (rowIndex == numRows - 1 || rowIndex == 0)
                step = -step;
            rowIndex += step;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i<numRows; ++i) {
            res.append(zigzag[i]);
        }
        return String.valueOf(res);
    }
}