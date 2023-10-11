package com.iflytek.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 1000, 1111, 1234};
        int index = insertValueSearch(arr, 0, arr.length-1, 1000);
        System.out.println("index = " + index);

    }

    /**
     * 编写插值查找算法
     * 说明：插值查找算法，也要求数组是有序的
     *
     * @param arr       数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 查找值
     * @return 如果找到就返回对应的下标，如果没有找到就返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        // 注意：findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要
        // 否则我们得到的 mid 可能越界
        if (left > right || arr[0] > findValue || arr[arr.length-1] < findValue) {
            return -1;
        }
        // 求出mid, 自适应
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        if (findValue > arr[mid]) {// 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else if (findValue < arr[mid]) {// 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
