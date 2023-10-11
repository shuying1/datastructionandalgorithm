package com.iflytek.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {102, 23, 354, -5, 0};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    public static void shellSort(int arr[]) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                //当退出while 后，就给 temp 找到插入的位置
                arr[j] = temp;
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }

    }
}
