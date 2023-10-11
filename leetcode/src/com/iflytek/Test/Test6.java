package com.iflytek.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yings
 * @create 2023-03-06 14:29
 */
public class Test6 {
    public static void main(String[] args) {
        String str="sdfasdfsdfassssss";
        numCharAndTime(str);
    }
    public static void numCharAndTime(String str){
        Map<Character,Integer> map=new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
//        int maxNum=0;
//        char ch='\0';

        int maxNum= Collections.max(map.values());
        System.out.println(map);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue()>maxNum){
//                maxNum=entry.getValue();
//                ch=entry.getKey();
//            }

            if (entry.getValue()==maxNum){
                System.out.println(maxNum);
                System.out.println(entry.getKey());
            }
        }
        System.out.println(maxNum);
//        System.out.println(ch);

    }
}
