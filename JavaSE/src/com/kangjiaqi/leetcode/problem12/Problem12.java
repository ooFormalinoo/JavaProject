package com.kangjiaqi.leetcode.problem12;

public class Problem12 {
    public static void main(String[] args) {
        Problem12 p = new Problem12();
        int num = 12;
        System.out.println(p.intToRoman(num));
    }
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            while (num > 0 && num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

}
