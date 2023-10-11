package com.iflytek.Test;

/**
 * @author yings
 * @create 2022-08-02 10:11
 */
public class Test {
    public static void main(String[] args) {
        String str = "abcd";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s = "";
            for (int j = i; j < chars.length; j++) {
                s += chars[j];
                System.out.println(s);
            }
        }
    }
}
