package com.iflytek.string;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-06-08 9:45
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString3(s);
        System.out.println("Arrays.toString(s) = " + Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char c = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = c;
        }
    }

    //交换两个数字的值
    //https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247486352&idx=1&sn=2c2a196b94342e98c8339c5074e9ea57&chksm=fb4198b0cc3611a6edfdd46da64f2353f160810ed319cd2fc76f0e78f0d78e89e93612c5bb89&token=910002910&lang=zh_CN#rd
    //这里可以写一个交换函数
    public static void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    //递归
    public static void reverseString3(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverseStringHelper(s, 0, s.length - 1);
    }

    private static void reverseStringHelper(char[] s, int left, int right) {
        if (left < right) {
            swap(s, left, right);
            //这里要前置++/--
            reverseStringHelper(s, ++left, --right);
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
