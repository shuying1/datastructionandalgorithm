package com.iflytek.Test;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-09-07 17:07
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int len=arr.length;
        int[] arr2=new int[len-1];
        for (int i = 0; i < len - 1; i++) {
            arr2[i]=arr[i];
        }
        arr=arr2;
        System.out.println(Arrays.toString(arr));
    }
}
