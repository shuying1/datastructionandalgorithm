package com.iflytek.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };// 有顺序的数组
        //数组长度减不减1，没有关系
        int index = binarySearch(arr, 0, arr.length , 1000);
        System.out.println("index = " + index);

        List<Integer> indexList = binarySearch2(arr, 0, arr.length , 1000);
        System.out.println("indexList = " + indexList);
    }

    /**
     * @param arr   数组
     * @param left  左边的索引
     * @param right 右边的索引
     * @param value 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        if (arr[mid] == value) {
            return mid;
        } else if (value < arr[mid]) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return binarySearch(arr, mid + 1, right, value);
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }

        if (value > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, value);
        } else {
            //* 思路分析
            // * 1. 在找到mid 索引值，不要马上返回
            //* 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            // * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            // * 4. 将Arraylist 返回
            List<Integer> list = new ArrayList<>();
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            // while (temp>0&&arr[temp]==value)也可以
            while (true) {//退出
                if (temp < 0 || arr[temp] != value) {//因为相同的数必相邻
                    break;
                }
                //否则，就 temp 放入到 list
                list.add(temp);
                temp--;//temp 左移
            }
            list.add(mid);
            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
             // while (temp<right&&arr[temp]==value)也可以
            while (true) {
                if (temp > right || arr[temp] != value) {
                    break;
                }
                //否则，就 temp 放入到 list
                list.add(temp);
                temp++;//temp 右移
            }
            return list;
        }

    }
}

