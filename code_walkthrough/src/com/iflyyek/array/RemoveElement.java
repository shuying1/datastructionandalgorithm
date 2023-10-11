package com.iflyyek.array;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-09-17 21:35
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int value = 3;
        int size = removeElement3(nums, value);
        System.out.println("size = " + size);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param value
     * @return
     */
    public static int removeElement(int[] nums, int value) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {//遍历原数组
            if (value == nums[i]) {// 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < length; j++) {//更新新数组
                    nums[j - 1] = nums[j];
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                length--;// 此时数组的大小-1
            }

        }
        return length;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @param value
     * @return
     */
    public static int removeElement2(int[] nums, int value) {
        int fastIndex = 0;
        int slowIndex = 0;
        int length = nums.length;
        while (fastIndex < length) {
            if (nums[fastIndex] != value) {
                nums[slowIndex++] = nums[fastIndex];
            }
            fastIndex++;
        }
        return slowIndex;
    }

    /**
     * 相向双向指针法
     *
     * @param nums
     * @param value
     * @return
     */
    public static int removeElement3(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == value) right--; //将right移到从右数第一个值不为val的位置
        while (left <= right) {
            if (nums[left] == value) {//left位置的元素需要移除
                nums[left] = nums[right--]; //将right位置的元素移到left（覆盖），right位置移除
            }
            left++;
            while (right >= 0 && nums[right] == value) right--;
        }
        return left;
    }
}
