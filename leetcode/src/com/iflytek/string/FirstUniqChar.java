package com.iflytek.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yings
 * @create 2022-06-29 20:50
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "aabb";
        int i = firstUniqChar2(s);
        System.out.println("i = " + i);

    }

    public static int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    public static int firstUniqChar2(String s) {
        int[] count=new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            count[chars[i]-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
