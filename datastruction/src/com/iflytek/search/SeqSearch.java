package com.iflytek.search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组
        int index=seqSearch(arr,34);
        System.out.println("index = " + index);
    }
    //这里我们实现的线性查找是找到一个满足条件的值，就返回
    public static int seqSearch(int arr[],int value){
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (value==arr[i]){
                return i;
            }
        }
        return -1;

    }
}
