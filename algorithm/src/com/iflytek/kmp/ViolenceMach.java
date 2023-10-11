package com.iflytek.kmp;

/**
 * @author yings
 * @create 2022-06-11 12:32
 */
public class ViolenceMach {
    public static void main(String[] args) {
        //判断是否匹配成功
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你~";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    // 暴力匹配算法实现
    // 双重for循环不好使
    public static int violenceMatch(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int i = 0;// i 索引指向 s1
        int j = 0;// j 索引指向 s2
        while (i < n1 && j < n2) {// 保证匹配时，不越界
            //匹配 ok
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }else {//没有匹配成功
                i=i-(j-1);
                j=0;
            }
        }
        //判断是否匹配成功
        if (j == str2.length()) {
            return i - j;
        } else {
            return 0;
        }

    }
}
