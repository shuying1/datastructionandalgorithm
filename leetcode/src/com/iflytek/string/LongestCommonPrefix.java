package com.iflytek.string;

/**
 * @author yings
 * @create 2022-08-31 11:21
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String str = longestCommonPrefix2(strs);
        System.out.println("str = " + str);
    }

    /**
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * 找出长度最小的字符串 (也可以任取一个字符串)
     * 用长度最小的字符串 去与 每个字符匹配， 不成功则长度减一，继续匹配，直至成功或长度为0则停止
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        // 找出最小长度的的字符串
        int strMinLength = Integer.MAX_VALUE;
        String minStr = "";
        for (String str : strs) {
            if (str.length() < strMinLength) {
                strMinLength = str.length();
                minStr = str;
            }
        }

        for (String str : strs) {
            while (strMinLength > 0) {
                boolean start = str.startsWith(minStr.substring(0, strMinLength));
                if (start) {
                    break;
                } else {
                    strMinLength--;
                }
            }
        }
        return minStr.substring(0, strMinLength);
    }

    /**
     * 先取第一个字符串当做他们的公共前缀
     * 然后找出他和第2个字符串的公共前缀，然后再用这个找出的公共前缀分别和第3个，第4个……判断
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        //默认第一个字符串是他们的公共前缀
        String strMin = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(strMin) != 0){
                strMin = strMin.substring(0, strMin.length() - 1);
            }
            i++;
        }
        return strMin;
    }

}
