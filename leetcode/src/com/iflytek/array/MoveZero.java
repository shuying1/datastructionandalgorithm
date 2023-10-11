package com.iflytek.array;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-06-10 22:18
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int n=nums.length;
        int index=0;
        for (int i = 0; i < n; i++) {
            if (nums[i]!=0){
                //一次遍历，把非零的都往前挪
                nums[index++]=nums[i];
            }
        }
        //后面的都是0
        while (index<n){
            nums[index++]=0;
        }

    }
    public static void moveZeroes2(int[] nums) {
        int i=0;//统计前面0的个数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j]==0){//如果当前数字是0就不操作
                i++;
            }else if (i!=0){
                //否则，把当前数字放到最前面那个0的位置，然后再把
                //当前位置设为0
                nums[j-i]=nums[j];
                nums[j]=0;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //只要不为0就往前挪
            if (nums[j] != 0) {
                //i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

}
