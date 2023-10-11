package com.iflytek.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int tmp = 0;
        System.out.println("堆排序");
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        /*
         * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
         * 3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
         */
        for (int i = arr.length - 1; i > 0; i--) {
            tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap(arr, 0, i);
        }
    }


    /**
     * 将一个数组(二叉树), 调整成一个大顶堆
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例 int arr[]={4,6,8,5,9};=>i=1=>adjustHeap=>得到 {4,9,8,5,6}
     * 如果我们再次调用adjustHeap传入的是i=0=>得到 {4,9,8,5,6}=>{9,6,8,5,4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量
        int tmp = arr[i];
        //开始调整
        // 说明K
        // 1. k = i * 2 + 1 k 是 i 结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //先让两个子节点进行比较
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子结点的值小于右子结点的值
                k++;// k 指向右子结点
            }
            if (arr[k] > tmp) {//如果子结点大于父结点
                arr[i] = arr[k];//把较大的值赋给当前结点
                i = k;//!!! i 指向 k,继续循环比较
            } else {
                break;
            }
        }
        arr[i] = tmp;//将 temp 值放到调整后的位置
    }
}
