package com.iflytek.Test;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-09-08 10:27
 */
public class Test4 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int num = 9;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num > arr[i]) {
                index = i + 1;
            }
        }

        int arr2[] = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            arr2[i] = arr[i];
        }
        arr2[index] = num;
        for (int i = index + 1; i < arr2.length; i++) {
            arr2[i] = arr[index++];
        }
        System.out.println(Arrays.toString(arr2));

    }
}
