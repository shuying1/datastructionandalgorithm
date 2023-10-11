package com.iflytek.sort;


import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {102, 23, 354, -5, 0};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insert(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];//如果不记录后面会覆盖掉
            int insertIndex = i - 1;//插入点初始化是inserter前面的一个元素
            if (arr[insertIndex] > insertVal) {
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {// 用while可以直接一次性写在判断中
                    arr[insertIndex + 1] = arr[insertIndex];
                    insertIndex--;
                }
                if (insertIndex != i - 1) {
                    arr[insertIndex + 1] = insertVal;
                    System.out.println("第" + i + "次" + Arrays.toString(arr));
                }
            }
        }
    }
}
