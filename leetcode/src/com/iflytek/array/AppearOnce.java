package com.iflytek.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yings
 * @create 2022-06-08 16:42
 */
public class AppearOnce {
    public static void main(String[] args) {
        int nums[] = {2, 2, 1,4,4,0,0,1,7};
        int num = singleNumber2(nums);
        System.out.println("num = " + num);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
//            set.add(num);
            if (!set.add(num)) {//判断条件不成立，但他也加到set中了
                //如果添加失败，说明这个值
                //在集合Set中存在，我们要
                //把他给移除掉
                set.remove(num);
            }
        }
        //最终集合Set中只有一个元素，我们直接返回
        return (int) set.toArray()[0];
    }


}
