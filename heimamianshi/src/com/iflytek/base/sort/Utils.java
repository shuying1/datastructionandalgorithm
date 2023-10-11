package com.iflytek.base.sort;

/**
 * @author yings
 * @create 2023-10-11 15:07
 */
public class Utils {

    public static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
}
