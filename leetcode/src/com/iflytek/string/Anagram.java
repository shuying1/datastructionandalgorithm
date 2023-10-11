package com.iflytek.string;

import java.util.Arrays;

/**
 * @author yings
 * @create 2022-07-02 23:14
 */
public class Anagram {
    public static void main(String[] args) {
        boolean anagram = isAnagram3("anagram", "nagaram");
        System.out.println("anagram = " + anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] letterCount=new int[26];
        //统计字符串s中每个字符的数量
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i)-'a']++;
        }
        //减去字符串t中每个字符的数量
        for (int i = 0; i < t.length(); i++) {
            if (letterCount[t.charAt(i)-'a']==0){
                return false;
            }
            letterCount[t.charAt(i)-'a']--;
        }
        //如果数组letterCount中每个值都是0，返回true，否则返回false
//        for (int count : letterCount) {
//            if (count!=0){
//                return false;
//            }
//        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        if (Arrays.equals(chars,chart)) {
            return true;
        }
        return false;
    }
    public static boolean isAnagram3(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] chart=t.toCharArray();
        char[] chars = s.toCharArray();

        int[] letter=new int[26];
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (++letter[chars[i]-'a']==1){
                count++;
            }
            if (--letter[chart[i]-'a']==0){
                count--;
            }
        }
        return count==0;
    }
}
