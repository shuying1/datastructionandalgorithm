package com.iflytek.array;

/**
 * @author yings
 * @create 2022-06-16 10:31
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate3(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] matrixNew=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                matrixNew[j][n-1-i]=matrix[i][j];
            }
        }
        //二维数组 copy不了
//        matrix = Arrays.copyOf(matrixNew,n );
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]=matrixNew[i][j];
            }

        }

    }

    public static void rotate2(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;

                //画图自己找规律看是怎么替换的
//                int temp=matrix[j][n-1-i];
//                matrix[j][n-1-i]=matrix[i][j];
//                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
//                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
//                matrix[i][j]=temp;
            }
        }

    }

    public static void rotate3(int[][] matrix) {
        int n=matrix.length;
        //先上下交换
        for (int i = 0; i < n / 2; i++) {
            //看成一个一维数组
            int[] tmp=matrix[i];
            matrix[i]=matrix[n-1-i];
            matrix[n-1-i]=tmp;
        }
        //再按照对角线交换
        for (int i = 0; i < n; i++) {
            //解决i和j相等的情况
            for (int j = i+1; j < n; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }
}
