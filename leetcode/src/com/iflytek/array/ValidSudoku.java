package com.iflytek.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yings
 * @create 2022-06-12 21:36
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = isValidSudoku(board);
        System.out.println("result = " + result);
    }



    public static boolean isValidSudoku(char[][] board) {
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]，因为数独中的数字是1~9
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') {
                    continue;
                }
                //num是当前格子的数字
                int num = board[i][j] - '0' - 1;//数组中取不到9
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0) {
                    return false;
                }
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];

        int shift = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') {
                    continue;
                }
                shift = 1 << (board[i][j] - '0');
                int k = (i / 3) * 3 + j / 3;
                //如果对应的位置只要有一个大于0，说明有冲突，直接返回false
                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0) {
                    return false;
                }
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }

    //用hashMap存储行和列以及每个 3 X 3 格子出现的数字
    public static boolean isValidSudoku3(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int num = c - '0';
                if (c == '.') {
                    continue;
                }
                //这里有点巧
                int k = (i / 3) * 3 + j / 3;
                if (row.get(i).contains(num) || col.get(j).contains(num) || area.get(k).contains(num)) {
                    return false;
                }
                row.get(i).add(num);
                col.get(j).add(num);
                area.get(k).add(num);
            }
        }
        return true;
    }

    public static boolean isValidSudoku4(char[][] board) {
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j] ;
                if (c == '.') {
                    continue;
                }
                int num=c-'0';
                int k = i / 3 * 3 + j / 3;

                if (row[i][num] || col[j][num] || area[k][num]) {
                    return false;
                }
                row[i][num] = col[j][num] = area[k][num] = true;
            }
        }
        return true;
    }
}
