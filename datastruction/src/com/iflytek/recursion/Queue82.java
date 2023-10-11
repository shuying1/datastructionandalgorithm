package com.iflytek.recursion;


public class Queue82 {
    //棋盘格子的范围，以及皇后的数量（应该分开定义，这里偷懒了）
    static final int MAX_NUM = 8;
    //二维数组作为棋盘
    static int[][] chessBoard = new int[MAX_NUM][MAX_NUM];

    public static boolean check(int x, int y) {
        for (int i = 0; i < y; i++) {
            //检查纵向
            if (chessBoard[x][i] == 1) {
                return false;
            }
            //检查左侧斜向
            if (x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i] == 1) {
                return false;
            }
            //检查右侧斜向
            if (x + 1 + i < MAX_NUM && chessBoard[x + 1 + i][y - 1 - i] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean selectQueue(int y) {
        //行数超过8，说明已近找出答案
        if (y == MAX_NUM) {
            return true;
        }
        for (int i = 0; i < MAX_NUM; i++) {
            //为当前行清0，以免回溯的时候出现脏数据
//            for (int j = 0; j < MAX_NUM; j++) {
//                chessBoard[j][y] = 0;
//            }
            //检查是否符合规则，如果符合，更改元素值并进一步递归
            if (check(i, y)) {
                chessBoard[i][y] = 1;
                //递归如果返回true，说明下层已近找到解决，无须继续循环
                if (selectQueue(y + 1)) {
                    return true;
                }else {
                    chessBoard[i][y]=0;
                }
            }
        }
        return false;
    }

    public static void print() {
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue82 queue82 = new Queue82();
        queue82.selectQueue(0);
        queue82.print();
    }
}
