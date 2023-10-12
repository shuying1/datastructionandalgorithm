package com.iflytek.base.sort;

import java.util.Arrays;

/**
 * @author yings
 * @create 2023-10-12 16:22
 */
public class insert {
    public static void main(String[] args) {
        int[] a = {7, 5, 19, 8, 4, 1};
        insert(a);
    }

    private static void insert(int[] a){
        for (int i = 1; i < a.length ; i++) {
            // i 代表待插入元素的索引
            int t=a[i];// 代表待插入的元素值
            int j=i;
            while (j>=1){
                if (t<a[j-1]){// j-1 是上一个元素索引，如果 > t，后移
                    a[j]=a[j-1];
                    j--;
                }else {// 如果 j-1 已经 <= t, 则 j 就是插入位置
                    break;
                }
            }
            a[j]=t;
            System.out.println(Arrays.toString(a) + " " + j);
        }
    }
}
