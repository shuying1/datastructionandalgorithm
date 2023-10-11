package com.iflytek.base.binarysearch;

import java.util.Arrays;


/**
 * @author yings
 * @create 2023-10-11 14:30
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 11, 22, 19, 31, 35, 40, 45, 48, 49, 50};
        int target = 1;
        int idx = binarySearch(array, target);
        System.out.println("idx = " + idx);
    }

    /**
     *  二分查找, 找到返回元素索引，找不到返回 -1
     * @param a
     * @param t
     * @return
     */
    public static int binarySearch(int[] a, int t) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int left = 0, right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (a[mid] == t) {
                return mid;
            } else if (a[mid] > t) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
//        没找到则返回-1
        return -1;
    }

}
