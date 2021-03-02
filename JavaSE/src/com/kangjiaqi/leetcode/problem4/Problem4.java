package com.kangjiaqi.leetcode.problem4;
/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays
 * time complexity should be O(log(m+n))*/

/*思路: 因为已知了两个数组的长度，则该问题变成了两个有序数组求第k小的数，折半删除*/
public class Problem4 {
    public static void main(String[] args) {
        Problem4 p = new Problem4();
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6};
        double res = p.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k1 = (m + n + 1) / 2;
        int k2 = (m + n + 2) / 2;
        int r1 = findKth(nums1, nums2, 0, 0, k1);
        int r2 = findKth(nums1, nums2, 0, 0, k2);
        return (r1 + r2) / 2.0;

    }

    public int findKth(int[] num1, int[] num2, int idx1, int idx2, int k) {
        if (idx1 >= num1.length) {
            return num2[idx2 + k - 1];
        }
        if (idx2 >= num2.length) {
            return num1[idx1 + k - 1];
        }
        if (k == 1) {
            return Math.min(num1[idx1], num2[idx2]);
        }
        int newIdx1 = Math.min(idx1 + k / 2 - 1, num1.length - 1);
        int newIdx2 = Math.min(idx2 + k / 2 - 1, num2.length - 1);
        if (num1[newIdx1] < num2[newIdx2]) {
            return findKth(num1, num2, newIdx1 + 1, idx2, k - (newIdx1 - idx1 + 1));
        } else {
            return findKth(num1, num2, idx1,  newIdx2 + 1, k - (newIdx2 - idx2 + 1));
        }
    }
}
