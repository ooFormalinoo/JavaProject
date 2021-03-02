package com.kangjiaqi.leetcode.problem50;

public class Problem50 {
    public static void main(String[] args) {
        Problem50 p = new Problem50();
        double result = p.myPow(2, -2);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (n >= 0) return help(x, (long)n);
        else return 1 / help(x, -(long)n);
    }

    public double help(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double temp = help(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}
