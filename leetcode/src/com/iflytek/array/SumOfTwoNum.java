package com.iflytek.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yings
 * @create 2022-06-12 21:02
 */
public class SumOfTwoNum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target-nums[i])!=null){//如果未找到则返回为空
//                if (map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
