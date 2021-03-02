package com.kangjiaqi.leetcode.problem29;

public class Problem29 {
    public static void main(String[] args) {
        Problem29 p = new Problem29();
        long result = p.divide(-2147483648, -1);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
    }

    public long divide(int dividend, int divisor) {
        long sign = 1;
        long a = dividend;
        long b = divisor;
        if (a < 0) {
            a = -a;
            sign = -sign;
        }
        if (b < 0) {
            b = -b;
            sign = -sign;
        }
        long left = 0;
        long right = a;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mul(b, mid) == a) {
                return mid > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)(mid * sign);
            } else if (mul(b, mid) < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)(right * sign);
    }

    public long mul(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) ans += a;
            b = b >> 1;
            a += a;
        }
        return ans;
    }
}
