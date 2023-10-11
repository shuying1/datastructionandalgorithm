package com.iflytek.dynamic;

/**
 * @author yings
 * @create 2022-06-07 14:48
 */
public class Knapsack {

    static int capacity = 11;// 背包容量
    static int num = 5;// 物品数量
    static int[] weight = {0, 1, 2, 5, 6, 7};// 下标从1开始，前5件商品的数量
    static int[] value = {0, 1, 6, 18, 22, 28};// 标从1开始,前5件商品重量

    public static void main(String[] args) {
        // 求出装入前5件物品（全部物品）背包容量剩余11（全部容量）时的最大价值
        int maxValue = getMax(num, capacity);
        System.out.println("可以装入的最大价值：" + maxValue);
    }

    /**
     * 递归方式求解
     *
     * @param i 装入前i件商品
     * @param w 剩余背包容量w
     * @return 当前情况下的最大价值
     */
    public static int getMax(int i, int w) {
        if (i == 0 || w == 0) {// 装入前0件物品/背包容量为0时的最大价值肯定为0
            return 0;
        }
        if (w < weight[i]) {// 剩余容量装不下第i件物品
            return getMax(i - 1, w);
        } else {
            // 如果能装入，则判断装入后价值大，还是不装入价值大
            return Math.max(getMax(i - 1, w - weight[i]) + value[i], getMax(i - 1, w));
        }
    }
}
