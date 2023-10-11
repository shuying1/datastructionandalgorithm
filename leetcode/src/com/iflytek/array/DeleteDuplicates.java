package com.iflytek.array;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-06-08 9:44
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        int nums[]={1,2,2,3};
        System.out.println("removeDuplicates(nums) = " + removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        //边界条件判断
        if (nums.length == 0 && nums == null) {
            return 0;
        } else {
            while (right < nums.length) {
//                if (nums[left] == nums[right]) {
//                    right++;
//                } else {
//                    nums[++left] = nums[right++];
//                }

                //如果左指针和右指针指向的值一样，说明有重复的，
                //这个时候，左指针不动，右指针继续往右移。如果他俩
                //指向的值不一样就把右指针指向的值往前挪
                if (nums[left]!=nums[right]){
                    nums[++left] = nums[right++];
                }else {
                    right++;
                }
            }
        }
        return left + 1;
    }



    public static int removeDuplicates2(int[] A) {
        int count = 0;//重复的数字个数
        for (int right = 1; right < A.length; right++) {
            if (A[right] == A[right - 1]) {
                //如果有重复的，count要加1
                count++;
            } else {
                //如果没有重复，后面的就往前挪
                A[right - count] = A[right];
            }
        }
        //数组的长度减去重复的个数
        return A.length - count;
    }

}
