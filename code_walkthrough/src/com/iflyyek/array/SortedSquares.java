package com.iflyyek.array;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-11-19 23:18
 */
public class SortedSquares {
    //暴力排序
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    //双指针法
    public static int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        int l=0;
        int r=nums.length-1;
        while (l<r){
            if(nums[l]*nums[l]>nums[r]*nums[r]){
                result[k--]=nums[l]*nums[l];
                l++;
            }else {
                result[k--]=nums[r]*nums[r];
                r--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] sortNums = sortedSquares2(nums);
        System.out.println(Arrays.toString(sortNums));
    }
}
