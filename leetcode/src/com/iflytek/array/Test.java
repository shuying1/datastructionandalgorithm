package com.iflytek.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yings
 * @create 2022-07-02 11:07
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 5, 2};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println("repeatNumber = " + repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int repeat=-1;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()==2){
                repeat=entry.getValue();
                break;
            }
        }
        return repeat;
    }
}
