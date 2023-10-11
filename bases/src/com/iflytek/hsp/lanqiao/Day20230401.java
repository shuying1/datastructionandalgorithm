package com.iflytek.hsp.lanqiao;

/**
 * @author yings
 * @create 2023-04-01 21:51
 */
public class Day20230401 {
    public static void main(String[] args) {
        restoreString("H3el5o2");
    }

    /**
     * 【问题描述】
     * ⼩明有⼀串很⻓的英⽂字⺟，可能包含⼤写和⼩写。
     * 在这串字⺟中，有很多连续的是重复的。⼩明想了⼀个办法将这串字⺟表达得更短：将连续的⼏个相
     * 同字⺟写成字⺟ + 出现次数的形式。
     * 例如，连续的 5 个 a，即 aaaaa，⼩明可以简写成 a5（也可能简写成 a4a、aa3a 等）。对于
     * 这个例⼦：HHHellllloo，⼩明可以简写成 H3el5o2。为了⽅便表达，⼩明不会将连续的超过 9
     * 个相同的字符写成简写的形式。
     * 现在给出简写后的字符串，请帮助⼩明还原成原来的串。
     * 【输⼊格式】
     * 输⼊⼀⾏包含⼀个字符串。
     * 【输出格式】
     * 输出⼀个字符串，表示还原后的串。
     * 【样例输⼊】
     * H3el5o2
     * 【样例输出】
     * HHHellllloo
     * 【评测⽤例规模与约定】
     * 对于所有评测⽤例，字符串由
     *
     * @param str
     */
    public static void restoreString(String str) {
        char cur='\0';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 字符包装类API http://www.51gjie.com/java/596.html
            if (Character.isLetter(c)) {
                cur = c;
                System.out.print(cur);
            } else if (Character.isDigit(c)) {
                int n = Character.digit(c, 10);
                // 已经输出第⼀个了
                for (int j = 0; j < n-1; j++) {
                    System.out.print(cur);
                }
            }
        }

    }
}
