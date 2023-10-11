package com.iflytek.binarysearchnorescure;

/**
 * @author yings
 * @create 2022-06-07 11:02
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        //测试
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);
    }

    //二分查找的非递归实现

    /**
     *
     * @param arr 待查找的数组, arr 是升序排序
     * @param target 需要查找的数
     * @return 需要查找的数
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) { //说明继续查找
            int mid = (left + right) / 2;
            if (arr[mid] < target) {//需要向右边查找
                left = mid + 1;
            } else if (arr[mid] > target) {//需要向左边查找
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
