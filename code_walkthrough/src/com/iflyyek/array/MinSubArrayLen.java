package com.iflyyek.array;

/**
 * @author yings
 * @create 2022-11-21 16:33
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int minLen = minSubArrayLen2(target, nums);
        System.out.println(minLen);
    }

    /**
     * 暴力解法
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;// 最终的结果
        int sum;// 子序列的数值之和
        int subLength = 0;// 子序列的长度
        for (int i = 0; i < nums.length; i++) {// 设置子序列起点为i
            sum = 0;//每次都要重新计算sum的值
            for (int j = i; j < nums.length; j++) {// 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= target) {// 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1;// 取子序列的长度
                    result = result < subLength ? result : subLength;
                    break;// 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 滑动窗口法
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;// 滑动窗口数值之和
        int i = 0;// 滑动窗口起始位置
        int result = Integer.MAX_VALUE;
        int subLength = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            if (sum >= target) {
                subLength = j - i + 1;// 取子序列的长度
                result = result < subLength ? result : subLength;
                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
                sum -= nums[i++];
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
