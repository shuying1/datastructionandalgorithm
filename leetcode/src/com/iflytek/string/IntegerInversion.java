package com.iflytek.string;

import javafx.util.converter.ShortStringConverter;

/**
 * @author yings
 * @create 2022-06-23 22:29
 */
public class IntegerInversion {
    public static void main(String[] args) {
        int x = 1534236469;
        int res = reverse3(x);
        System.out.println("res = " + res);

    }

    public static int reverse(int x) {
        int res = 0;// 反转的结果
        while (x != 0) {
            int pop = x % 10;// 取x的个位数
            int result = res * 10 + pop;
            // 判断是否溢出
            if ((result - pop) / 10 != res) {
                return 0;
            }
            x = x / 10;
            res = result;
        }
        return res;
    }

    public static int reverse2(int x) {
        int res = 0;// 反转的结果
        //-2^31 -2147483648 负数的最大值（int 范围内）
        //2^31   2147483647 正数的最大值（int 范围内）
        while (x != 0) {
            int pop = x % 10;// 取x的个位数
            // 判断是否有溢出
            if (x > 0) {// 正数的判断
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {

                    return 0;
                }
            } else {// 负数的判断
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop > 8)) {

                    return 0;
                }
            }
            res = res * 10 + pop;
            x = x / 10;
        }
        return res;
    }

    /**
     * 将整数转化为字符串处理，利用字符串反转
     *
     * @param x
     * @return
     */
    public static int reverse3(int x) {
        if (x == 0 || x == Integer.MIN_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        int flag = x > 0 ? 1 : -1;
        x = Math.abs(x);

        int num = 0;

        try {
            num = Integer.valueOf(new StringBuffer(String.valueOf(x)).reverse().toString());
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return 0;
        }
        return num * flag;

    }
}
