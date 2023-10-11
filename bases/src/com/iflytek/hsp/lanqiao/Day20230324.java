package com.iflytek.hsp.lanqiao;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yings
 * @create 2023-03-24 9:44
 */
public class Day20230324 {
    public static void main(String[] args) {
//        StringBuffer stringBuffer = nianHaoZiChuang(2019);
//        System.out.println("stringBuffer = " + stringBuffer);

//        shuLieQiuZhi();

//        int[] nums = {2, 6, 4, 10, 20};
//        dengChaShuLie(5, nums);

        huiWenRiQi(21233212);


        //迷宫
        long num = 0;
        String[] nn = {
                "01010101001011001001010110010110100100001000101010",
                "00001000100000101010010000100000001001100110100101",
                "01111011010010001000001101001011100011000000010000",
                "01000000001010100011010000101000001010101011001011",
                "00011111000000101000010010100010100000101100000000",
                "11001000110101000010101100011010011010101011110111",
                "00011011010101001001001010000001000101001110000000",
                "10100000101000100110101010111110011000010000111010",
                "00111000001010100001100010000001000101001100001001",
                "11000110100001110010001001010101010101010001101000",
                "00010000100100000101001010101110100010101010000101",
                "11100100101001001000010000010101010100100100010100",
                "00000010000000101011001111010001100000101010100011",
                "10101010011100001000011000010110011110110100001000",
                "10101010100001101010100101000010100000111011101001",
                "10000000101100010000101100101101001011100000000100",
                "10101001000000010100100001000100000100011110101001",
                "00101001010101101001010100011010101101110000110101",
                "11001010000100001100000010100101000001000111000010",
                "00001000110000110101101000000100101001001000011101",
                "10100101000101000000001110110010110101101010100001",
                "00101000010000110101010000100010001001000100010101",
                "10100001000110010001000010101001010101011111010010",
                "00000100101000000110010100101001000001000000000010",
                "11010000001001110111001001000011101001011011101000",
                "00000110100010001000100000001000011101000000110011",
                "10101000101000100010001111100010101001010000001000",
                "10000010100101001010110000000100101010001011101000",
                "00111100001000010000000110111000000001000000001011",
                "10000001100111010111010001000110111010101101111000"};
        char[][] tu = new char[30][50];
//        System.out.println(Arrays.toString(tu));

        int[][] dis = new int[30][50];
        int[][] step = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        char[] direction = {'D', 'L', 'R', 'U'};

        Queue<Integer> location = new LinkedList<Integer>();

        for (int i = 0; i < 30; i++) {
            tu[i] = nn[i].toCharArray();
        }

//        location.add(29 * 50 + 49);//对应数组下标
//        BFS(location, step, tu, dis);
//        String route = DFS(dis, step, tu, direction);
//        System.out.println(route);

    }

    /**
     * 年号字串
     * 小明用字母 A 对应数字 1，B 对应 2，以此类推，用 Z 对应 26。对于 27 以上的数字，
     * 小明用两位或更长位的字符串来对应，例如 AA 对应 27，AB 对应 28，AZ 对应 52，LQ 对应 329。
     * <p>
     * 请问 2019 对应的字符串是什么？
     *
     * @param n
     * @return
     */
    public static StringBuffer nianHaoZiChuang(int n) {
        char a[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuffer ans = new StringBuffer("");
        while (n > 0) {
            n--;// 因为26进制是 0 - 25,而题目中表示是 1 - 26，所以每一位都减1
            int now = n % 26;
            ans.append(a[now]);
            n /= 26;
        }
        ans.reverse();
        return ans;
    }

    /**
     * 数列求值
     * 给定数列 1,1,1,3,5,9,17,⋯，从第 4 项开始，每项都是前 3 项的和。
     * <p>
     * 求第 20190324 项的最后 4 位数字。
     *
     * @return
     */
    public static void shuLieQiuZhi() {
        int a = 1, b = 1, c = 1, d = 0;//数列前四项
        for (int i = 4; i <= 20190324; i++) {
            d = (a + b + c) % 10000;//只保留后四位
            a = b;
            b = c;
            c = d;
        }
        System.out.println(d);
//        System.out.println(c);  //打印c也一样
    }

    /**
     * 数学老师给小明出了一道等差数列求和的题目。但是粗心的小明忘记了一 部分的数列，只记得其中
     * N 个整数。现在给出这 N 个整数，小明想知道包含这 N 个整数的最短的等差数列有几项？
     *
     * @param n    数的个位数
     * @param nums 数
     */
    public static void dengChaShuLie(int n, int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int d = nums[1] - nums[0];
        //如果每一项相等的话
        if (d == 0) {
            System.out.println(n);
        } else {
            int num = (nums[nums.length - 1] - nums[0]) / d + 1;
            System.out.println(num);
        }

    }

    /**
     * 对于上面的迷宫，从入口开始，可以按 DRRURRDDDR 的顺序通过迷宫， 一共 10 步。
     * 其中 D、U、L、R 分别表示向下、向上、向左、向右走。 对于下面这个更复杂的迷宫（30 行 50 列），
     * 请找出一种通过迷宫的方式，其使用的步数最少，在步数最少的前提下，请找出字典序最小的一个作为答案。
     * <p>
     * 请注意在字典序中 D<L<R<U。
     * <p>
     * 010000
     * 000100
     * 001001
     * 110000
     */
    public static void miGong() {


//    保存经过的每一个点位置信息，采用(x)*m+y的公式表示(x,y);
//    x,y从0开始，位置也是从来开始。m:大于最长边的随便一个数
//    起点:0;终点:29*50-49
        Queue<Integer> location = new LinkedList<>();
//    广度优先遍历求每一个位置到终点的距离，并存放在dis中
//    广度优先遍历寻找所有从终点到起点的路线

    }

    public static void BFS(Queue<Integer> location, int[][] step, char[][] tu, int[][] dis) {
        //x,y当前位置;
        int x, y;
        while (!location.isEmpty()) {
            int l = location.poll();//poll也是查看，和peek类似，但会有异常处理
            x = l / 50;//获取当前位置x
            y = l % 50;//获取当前位置y

            for (int i = 0; i < 4; i++) {//探索四个方向
                int xx = x + step[i][0];
                int yy = y + step[i][1];
                /*               unicode码与'0' 等价*/
                if (xx >= 0 && xx < 30 && yy > 0 && yy < 50 && tu[xx][yy] == '0' && dis[xx][yy] == '0') {
                    dis[xx][yy] = dis[x][y] + 1;//当前位置的距离+1等于本次探索位置的距离
                    location.add(xx * 50 + yy);
                    if (xx == 0 && yy == 0) {
                        break;
                    }
                }
            }
        }
    }

    //    深度优先遍历，从起点到终点
    public static String DFS(int[][] dis, int[][] step, char[][] tu, char[] direction) {
        dis[29][49] = 0;
//        起点
        int x = 0;
        int y = 0;
        String route = "";
        while (x != 29 || y != 49) {
            for (int i = 0; i < 4; i++) {
                int xx = x + step[i][0];
                int yy = y + step[i][1];
                if (xx >= 0 && xx < 30 && yy >= 0 && yy < 50 && tu[xx][yy] == '0') {
                    if (dis[x][y] == dis[xx][yy] + 1) {
                        x = xx;
                        y = yy;
                        route += direction[i];
                        break;
                    }
                }
            }
        }
        return route;
    }

    /**
     * 2020 年春节期间，有一个特殊的日期引起了大家的注意：2020 年 2 月 2 日。
     * 因为如果将这个日期按 “yyyymmdd” 的格式写成一个 8 位数是 20200202，恰好是一个回文数。
     * 我们称这样的日期是回文日期。
     * 有人表示 20200202 是 “千年一遇” 的特殊日子。
     * 对此小明很不认同，因为不到 2 年之后就是下一个回文日期：20211202 即 2021 年 12 月 2 日。
     * 也有人表示 20200202 并不仅仅是一个回文日期，还是一个 ABABBABA 型的回文日期。
     * 对此小明也不认同，因为大约 100 年后就能遇到下一个 ABABBABA 型的回文日期：21211212 即 2121 年 12 月 12 日。
     * 算不上 “千年一遇”，顶多算 “千年两遇”。
     * <p>
     * 给定一个 8 位数的日期，请你计算该日期之后下一个回文日期和下一个 ABABBABA 型的回文日期各是哪一天。
     *
     * @param date
     */
    public static void huiWenRiQi(int date) {
        //在回文串与ABABABAB之间 有不止一个回文串，回文串的数小于ABABABAB
        int ok = 0;
        for (int i = date + 1; ; i++) {
            int y = i / 10000, m = i / 100 % 100, d = i % 100;
            int D = 31;
            if (m == 4 || m == 6 || m == 9 || m == 11) {
                D = 30;
            } else if (m == 2) {
                if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                    D = 29;
                } else {
                    D = 28;
                }
            }

            if (m < 1 || m > 12 || d < 1 || d > D) continue;//这个必须要判断，因为年份不是自己输入的，自增的有些不符合正常的日期
            // 判断回文
            if (i % 10 == i / 10000000 && i / 10 % 10 == i / 1000000 % 10 && i / 100 % 10 == i / 100000 % 10 && i / 10000 % 10 == i / 1000 % 10 && ok == 0) {
                System.out.println(i);
                ok = 1;
            }
            // 判断ABABBABA
            if (i % 10 == i / 10000000 && i % 10 == i / 100000 % 10 && i % 10 == i / 100 % 10 &&
                    i / 10 % 10 == i / 1000 % 10 && i / 10 % 10 == i / 10000 % 10 && i / 10 % 10 == i / 1000000 % 10) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void bigMultiolyBig(BigInteger a,BigInteger b){
        System.out.println(a.multiply(b).toString());
    }

}
