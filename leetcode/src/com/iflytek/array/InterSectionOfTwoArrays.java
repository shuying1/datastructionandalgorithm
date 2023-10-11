package com.iflytek.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yings
 * @create 2022-06-08 19:30
 */
public class InterSectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersect4(nums1, nums2);
        System.out.println("result = " + Arrays.toString(result));

    }

    public static Integer[] intersect(int[] nums1, int[] nums2) {
        // 先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        //如果使用数组不知道初始化大小
        //改用集合
        List<Integer> list = new ArrayList<>();
        int w = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                // 如果i指向的值小于j指向的值，说明i指向
                // 的值小了，i往后移一步
                i++;
            } else if (nums1[i] > nums2[j]) {
                // 如果i指向的值大于j指向的值，说明j指向的值
                // 小了，j往后移一步
                j++;
            } else {
                // 如果i和j指向的值相同，说明这两个值是重复的，
                // 把他加入到集合list中，然后i和j同时都往后移一步
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        Integer[] result = list.toArray(new Integer[list.size()]);
        //或用原始的方法
        //把list转化为数组
//        Integer[] result = new Integer[list.size()];
//        for (int k = 0; k < list.size(); k++) {
//            result[k] = list.get(k);
//        }

        return result;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        //优化空间
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);//将小的数组放在了第一个，妙
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            //getOrDefault
            // 当Map集合中有这个key时，就使用这个key对应的value值，如果没有这个key就使用默认值defaultValue
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static int[] intersect3(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        //先把数组nums1的所有元素都存放到map中，其中key是数组中
        //的元素，value是这个元素出现在数组中的次数

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，
        //就把当前值加入到集合list中，然后再把对应的value值减1。
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        //把集合list转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    /**
     * 暴力求解
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect4(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect4(nums2, nums1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    intersection[index++] = nums1[i];
                    break;
                }
            }
        }
        return Arrays.copyOf(intersection,index);
    }

}
