package com.iflytek.sort;


import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {102, 23, 354, -5, 0};
//        int arr[] = new int[80000000];
//        for (int i = 0; i < 80000000; i++) {
//            arr[i] = (int) (Math.random() * 80000);
//        }
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd:hh:mm:ss");
        String format = dateFormat.format(date1);
//        System.out.println("排序前");
        System.out.println(format);
//        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        Date date2 = new Date();
        String format1 = dateFormat.format(date2);
        System.out.println(format1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivoit = left;
        int index = pivoit + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivoit]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivoit, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int l = left, r = right, temp = arr[left];
            if (l < r) {
                while (l < r) {
                    while (l < r && arr[r] > temp)
                        r--;
                    if (l < r)
                        arr[l++] = arr[r];
                    while (l < r && arr[l] < temp)
                        l++;
                    if (l < r)
                        arr[r--] = arr[l];
                }
                arr[l] = temp;
                quickSort(arr, left, l - 1); // 递归调用
                quickSort(arr, r + 1, right);
            }
        }
    }
}
