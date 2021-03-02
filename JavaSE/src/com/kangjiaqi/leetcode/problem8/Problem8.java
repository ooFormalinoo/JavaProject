package com.kangjiaqi.leetcode.problem8;

public class Problem8 {
    public static void main(String[] args) {
        String s = "   -72";
        Problem8 p = new Problem8();
        System.out.println(p.myAtoi(s));
    }

    public int myAtoi(String s) {
        String ss = s.strip();
        if(ss.length()==0)
            return 0;
        if (ss.charAt(0) != '+' && ss.charAt(0) != '-' && (ss.charAt(0) < '0' || ss.charAt(0) > '9')) {
            return 0;
        }
        long maxInt = Integer.MAX_VALUE;
        long minInt = Integer.MIN_VALUE;
        int sign = 1;
        if (ss.charAt(0) == '+') {
            ss = ss.substring(1);
        }else if (ss.charAt(0) == '-') {
            ss = ss.substring(1);
            sign = -1;
        }
        if(ss.length()==0)
            return 0;
        if (ss.charAt(0) < '0' || ss.charAt(0) > '9')
            return 0;
        long result = 0;
        for (int i = 0; i < ss.length(); i++) {
            int curNum = ss.charAt(i) - '0';
            if (curNum >= 0 && curNum <= 9) {
                result = result * 10 + curNum;
                if (sign * result > maxInt) {
                    result = maxInt;
                    break;
                }
                if (sign * result < minInt) {
                    result = minInt;
                    break;
                }
            } else {
                break;
            }
        }
        return (int) (sign * result);
    }
}
