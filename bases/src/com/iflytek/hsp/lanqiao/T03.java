package com.iflytek.hsp.lanqiao;

import java.util.Scanner;

public class T03 {
// 除了第⼀次调⽤都应该是 a > b ，所以 base case 时 b == 0 , return a


    public static int gcb(int a, int b) {
        return (b == 0) ? a : gcb(b, a % b);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// int x0 = scanner.nextInt();
// int y0 = scanner.nextInt();
        int x0 = 3;
        int y0 = 60;
        int cnt = 0;
// p ⼀定⽐最⼤公约数⼤，⽐最⼩公倍数⼩ => p ~ [x0,y0]
        for (int p = x0; p <= y0; p++) {
// p ~ [x0,y0]
            for (int q = x0; q <= y0; q++) {
// 计算最⼤公约数
                int g = gcb(p, q);
                if (x0 == g) {
// 计算最⼩公倍数
                    int m = p * q / g;
                    if (m == y0) {
                        System.out.println("p=" + p + ",q=" + q);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}