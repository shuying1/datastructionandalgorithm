package com.iflytek.base.sort;

import java.util.Arrays;

/**
 * @author yings
 * @create 2023-10-11 14:50
 */
public class Bubble {
    public static void main(String[] args) {
        int[] a = {5, 2, 7, 4, 1, 3, 8, 9};
//        int[] a = {1, 2, 3, 4, 5, 7, 8, 9};
//        bubble(a);
        bubble_v2(a);
    }

    /**
     * 1：每经过一轮冒泡，内层循环就可以减少一次
     * 2：如果某一轮冒泡没有发生交换，则表示所有数据有序，可以结束外层循环
     *
     * @param array
     */
    public static void bubble(int[] array) {
        //比较的轮数
        for (int i = 0; i < array.length - 1; i++) {
            //每轮比较的次数
            boolean swapped = false;// 是否发生了交换
            for (int j = 0; j < array.length - 1 - i; j++) {
                System.out.println("比较次数" + j);
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + i + "轮冒泡"
                    + Arrays.toString(array));
            if (!swapped) {
                break;
            }
        }
    }


    /**
     * 每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数，
     * 如果这个值为零，表示整个数组有序，直接退出外层循环即可
     *
     * @param array
     */
    public static void bubble_v2(int[] array) {
        int n = array.length - 1;
        int lastChange=n;// 表示最后一次交换索引位置
        while (lastChange!=0){
            for (int j = 0; j < n; j++) {
                System.out.println("比较次数" + j);
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                    lastChange = j;
                }
            }
            n=lastChange;
            int i=0;
            System.out.println("第" + i++ + "轮冒泡"
                    + Arrays.toString(array));

        }
    }

}
