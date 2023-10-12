package com.iflytek.base.sort;

import java.util.Arrays;

/**
 * @author yings
 * @create 2023-10-12 15:24
 */
public class Select {
    public static void main(String[] args) {
        int[] a = {18,23, 19, 9, 23, 15};
        selection(a);
    }

    public static void selection(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            // i 代表每轮选择最小元素要交换到的目标索引
            int index=i;// 代表最小元素的索引
            for (int j = index+1; j <array.length ; j++) {
                if (array[index]>array[j]){// j 元素比 index 元素还要小, 更新 index
                    index=j;
                }
            }
            if (index!=i){
                Utils.swap(array,index,i);
            }
            System.out.println(Arrays.toString(array));
        }
    }

}
