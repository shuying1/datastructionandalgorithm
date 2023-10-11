package com.iflytek.string;


/**
 * @author yings
 * @create 2022-08-30 16:55
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi2("  "));
    }

    /**
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−2^31,2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
     * 返回整数作为最终结果。
     * <p>
     * 先去掉字符串两边的空格
     * 然后判断符号
     * 最后读取数字
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //去掉前后的空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //最终结果
        int res = 0;
        //符号，1是正数，-1是负数，默认是正数
        int sign = 1;
        //遍历字符串中字符的位置
        int index = 0;
        char[] chars = str.toCharArray();
        //判断符号，要在首个字符合法的前提下
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }
        for (; index < chars.length; index++) {
            //取出字符串中字符，然后转化为数字
            int num = chars[index] - '0';
            if (num < 0 || num > 9) {
                break;
            }
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + num;
            }

        }
        return sign * res;
    }

    public static int myAtoi2(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        int index = 0;
        // 先去除空格
        while (index < length && chars[index] == ' ') {
            index++;
        }
        // 极端情况 "  " 和""
        if (index >= length) {
            return 0;
        }
        // 再判断符号 //符号，1是正数，-1是负数，默认是正数
        int sign = 1;
        if (chars[index] == '-' || chars[index] == '+') {
            sign = chars[index] == '-' ? -1 : 1;
            index++;
        }
        int result = 0;
        int temp = 0;
        while (index < length) {
            int num = chars[index++] - '0';
            if (num > 9 || num < 0) {
                break;
            }
            temp = result;
            result = result * 10 + num;
            // 越界后，数值和期望数值发生变化，取余再除10获取原始值，比对判断
            if (result / 10 != temp) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return result * sign;

    }
}

