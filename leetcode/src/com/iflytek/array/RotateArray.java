package com.iflytek.array;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-06-08 10:52
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    //翻转次数k可能大于数组的长度
    public static void rotate1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, nums.length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void rotate3(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] isVisited = new boolean[length];

        for (int i = 0; i < length; i++) {
            index = (index+ k) % length;
            if (isVisited[index]) {
                //如果访问过，再次访问的话，会出现原地打转的现象，
                //不能再访问当前元素了，我们直接从他的下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;// i 是用来记录第几个元素的，由于这一步没有处理任何元素，所以i--
            } else {
                isVisited[index] = true;
                int tmp = nums[index];
                nums[index] = hold;
                hold = tmp;
            }
        }

    }
}
