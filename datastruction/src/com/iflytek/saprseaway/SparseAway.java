package com.iflytek.saprseaway;



/**
 * @author yings
 * @create 2022-02-05 23:08
 */
public class SparseAway {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        int initAway[][] = new int[11][11];
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子 初始化
        initAway[1][2] = 1;
        initAway[2][3] = 1;

        // 输出原始的二维数组
        System.out.println("------原始数组-------");
        for (int[] row : initAway) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组的思路
        // 1. 先遍历二维数组 得到非 0 数据的个数
        int sum = 0;
        for (int i = 0; i < initAway.length; i++) {
            for (int j = 0; j < initAway[i].length; j++) {
                if (initAway[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseAway[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseAway[0][0] = initAway.length;
        sparseAway[0][1] = initAway.length;
        sparseAway[0][2] = sum;

        // 遍历二维数组，将非 0 的值存放到 sparseArr 中
        //count 用来记录第几个非零数据
        int count = 0;
        for (int i = 0; i < initAway.length; i++) {
            for (int j = 0; j < initAway[i].length; j++) {
                if (initAway[i][j] != 0) {
                    count++;
                    sparseAway[count][0] = i;
                    sparseAway[count][1] = j;
                    sparseAway[count][2] = initAway[i][j];
                }
            }
        }
        System.out.println("------稀疏数组-------");
        for (int i = 0; i < sparseAway.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseAway[i][0], sparseAway[i][1], sparseAway[i][2]);
        }
        System.out.println();

        //将稀疏数组 --》 恢复成 原始的二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int initAway2[][] = new int[sparseAway[0][0]][sparseAway[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组即可
        for (int i = 1; i < sparseAway.length; i++) {
            initAway2[sparseAway[i][0]][sparseAway[i][1]] = sparseAway[i][2];
        }
        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int[] row : initAway2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

    }

}
