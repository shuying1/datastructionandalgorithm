package com.iflytek.Test;

/**
 * @author yings
 * @create 2023-02-27 16:40
 */
public class Main {

    public static void main(String[] args) {
//        Integer num=new Integer(2022);
//        String numHex = Integer.toHexString(num).toUpperCase();
//        System.out.println(numHex);

//        System.out.println(num());
//        System.out.println(test());
//        System.out.println(countSquare(2019, 324));

            int side1 = 2019;  // 矩形边长1
            int side2 = 324;   // 矩形边长2

            int count = 0;     // 统计正方形数量

            while (side1 > 0 && side2 > 0) {  // 只有两边长都大于0才能继续切
                if (side1 > side2) {          // 将长边赋给side1，短边赋给side2
                    int temp = side1;
                    side1 = side2;
                    side2 = temp;
                }

                int num = side2 / side1;       // 计算可以切出的正方形数量
                count += num;
                side2 -= side1 * num;          // 计算剩余矩形面积
            }

            System.out.println("小明最终会切出 " + count + " 个正方形");
        

    }




    public static int num() {
        Integer num = new Integer(2022);
        while (true) {

            String numHex = Integer.toHexString(num).toUpperCase();
            System.out.println(numHex);
            boolean flag = true;
            for (int i = 0; i < numHex.length(); i++) {
                if (numHex.charAt(i) < 'A' || numHex.charAt(i) > 'F') {
                    flag = false;
                    break;
                }
            }
            num++;
            if (flag) {
                return num;
            }
        }

    }

    public static int test() {
        int ans = 0, n = 40;
        for (int i = 1; i <= n; i++) {
            int t = i, ok = 0;
            while (t > 0) {
                int g = t % 10;
                if (g == 2 || g == 1 || g == 0 || g == 9) {
                    ok = 1;
                }
                t /= 10;
            }
            if (ok == 1) {
                ans += i;
            }

        }
        return ans;
    }

    public static int countSquare(int a,int b){
        if (a==b){
            return 1;
        }
        int res=0;
        while (a!=b){
            if (a>b){
                a-=b;
            }else {
                b-=a;
            }
            res++;
        }
        return res+1;//还有最后一块肯定是相等的
    }



}
