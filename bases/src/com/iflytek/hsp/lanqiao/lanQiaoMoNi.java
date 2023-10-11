package com.iflytek.hsp.lanqiao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yings
 * @create 2023-04-03 13:34
 */
public class lanQiaoMoNi {
    public static void main(String[] args) {
//        int x = 2022;
//        while (true) {
//            if (check(x))
//                break;
//            x ++;
//        }
//        System.out.println(x);

        test1();
    }
    public  static boolean check(int x) {
        while (x != 0)
            if (x % 16 <= 9)
                return false;
            else
                x /= 16;
        return true;
    }
    
    public static void test1(){
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');
        set.add('f');

        for (int i = 2023; ; i++) {
            String numStr = Integer.toHexString(i);
            boolean flag=true;
            for (int j = 0; j < numStr.length(); j++) {
                if (numStr.charAt(0)=='0'){
                    continue;
                }
                if (!set.contains(numStr.charAt(j))){
                    flag=false;
                    break;
                }

            }
            if (flag){
                System.out.println(i);
                return;
            }

        }

    }

}




