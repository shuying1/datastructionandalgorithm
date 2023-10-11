package com.iflytek.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yings
 * @create 2022-06-08 16:23
 */
public class RepeatElements {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean result = containsDuplicate(nums);
        System.out.println("result = " + result);

    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            //因为集合set中不能有重复的元素，如果有重复的
            //元素添加，就会添加失败
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //如果有重复的，set中会覆盖，导致size减小，
        //如果没有重复的，set的大小等于nums的长度
        return set.size() != nums.length;
    }

}
