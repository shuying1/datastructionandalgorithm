package com.iflyyek.array;

/**
 * @author yings
 * @create 2022-09-17 20:51
 */

/***
 * 前提是数组为有序数组，同时题目还强调数组中无重复元素，
 * 因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的，
 * 这些都是使用二分法的前提条件，
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 9, 10};
        int target = 10;
        int index = binarySearch2(nums, target);
        System.out.println("index = " + index);
    }

    /**
     * 左闭右闭的写法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
            int mid = left + ((right - left) >> 1);//注意加号的优先级高于位移运算符// 防止溢出 等同于(left + right)/2
            if (target > nums[mid]) {
                left = mid + 1;// target 在右区间，所以[middle + 1, right]
            } else if (target < nums[mid]) {
                right = mid - 1;// target 在左区间，所以[left, middle - 1]
            } else {// nums[middle] == target
                return mid;// 数组中找到目标值，直接返回下标
            }
        }
        // 未找到目标值
        return -1;
    }

    /**
     * 左闭右开的写法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;// 定义target在左闭右开的区间里，即：[left, right)
        while (left < right) {// 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int mid = left + ((right - left) >> 1);
            if (target > nums[mid]) {
                left = mid + 1; // target 在右区间，在[middle + 1, right)中
            } else if (target < nums[mid]) {
                right = mid;// target 在左区间，在[left, middle)中
            } else {
                return mid;
            }
        }
        return -1;
    }
}
