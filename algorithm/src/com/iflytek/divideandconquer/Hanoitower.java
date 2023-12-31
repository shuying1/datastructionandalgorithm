package com.iflytek.divideandconquer;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * @author yings
 * @create 2022-06-07 11:15
 */
public class Hanoitower {
    public static void main(String[] args) {
        Date time1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY/MM/dd:HH:mm:ss");
        String format = simpleDateFormat.format(time1);
        System.out.println(format);
        hanoiTower(5,'A','B','C');
        Date time2=new Date();
        String format1 = simpleDateFormat.format(time2);
        System.out.println(format1);


    }

    //汉诺塔的移动的方法
    //使用分治算法
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第"+num+"个盘从" + a + "->" + c);
        } else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoiTower(num-1,a,c,b);
            //2. 把最下边的盘 A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3. 把 B 塔的所有盘 从 B->C , 移动过程使用到 a 塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
