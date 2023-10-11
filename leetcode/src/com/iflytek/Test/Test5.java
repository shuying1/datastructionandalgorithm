package com.iflytek.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author yings
 * @create 2022-09-12 15:27
 */
public class Test5 {
    public static void main(String[] args) {
//        int nums=monkeyEatPeach(8);
//        System.out.println("nums = " + nums);


//        Dog dog=new Dog("小王",19);
//        System.out.println(dog.name);
//        System.out.println(dog.age);


        //String name;
//        int age=0;
//        System.out.println(age);
        guess();
    }

    /**
     * 0 表示石头
     * 1 表示剪刀
     * 2 表示布
     */
    public static void guess() {
        int computerNum = (int) (Math.random() * 3);
        System.out.println("请输入你要出的");
        Scanner sc = new Scanner(System.in);
        int myNum = sc.nextInt();
        System.out.println("电脑输出的"+computerNum);
        if (myNum == 0 && computerNum == 1) {
            System.out.println("你赢了");
        } else if (myNum == 1 && computerNum == 2) {
            System.out.println("你赢了");
        }else if (myNum == 2 && computerNum == 0){
            System.out.println("你赢了");
        }else if (computerNum==myNum){
            System.out.println("平局");
        }else {
            System.out.println("电脑赢了");
        }
    }

    /**
     * 猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
     * 以后每天猴子都吃其中的一半，然后再多吃一个。当到第 10 天时，
     * 想再吃时（即还没吃），发现只有 1 个桃子了。
     * 问题：最初共多少个桃子？
     *
     * @param days
     * @return
     */
    public static int monkeyEatPeach(int days) {
        if (days == 10) {
            return 1;
        } else {
            return (monkeyEatPeach(days + 1) + 1) * 2;
        }
    }
}

class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
