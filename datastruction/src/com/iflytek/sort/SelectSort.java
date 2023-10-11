package com.iflytek.sort;


import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={102,23,354,-5,0};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        select(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //选择排序时间复杂度是 O(n^2)
    public static void select(int[] arr){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {//只要比较数组大小-1次
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex]>arr[j]){// 说明假定的最小值，并不是最小
                    minIndex=j;//// 重置minIndex
                }
            }
            if (i!=minIndex){
                temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
                System.out.println("第"+(i+1)+"次"+Arrays.toString(arr));
            }
        }
    }
}
