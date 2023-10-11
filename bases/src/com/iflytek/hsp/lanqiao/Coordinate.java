package com.iflytek.hsp.lanqiao;


/**
 * @author yings
 * @create 2023-02-23 11:39
 */
public class Coordinate {
    public static void main(String[] args) {
        Mat mat = new Mat(5, 8);
        mat.print();

        mat = new MyMat();
        mat.print();

    }
}

class Pos {
    public int x;
    public int y;
    public int dx;
    public int dy;

    public Pos(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Pos(Pos t) {
        x = t.x;
        y = t.y;
        dx = t.dx;
        dy = t.dy;
    }
}

class Mat {
    private int row;
    private int col;

    public Mat() {
        row = 5;
        col = 5;
    }

    public Mat(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void showArray(int[][] ar) {
        System.out.println();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(String.format("%3d", ar[i][j]));
            }
            System.out.println();
        }
    }

    public void print() {
        int n = row * col;
        int[][] ar = new int[row][col];
        Pos cur = initPos();
        int m = 1;
        for (; ; ) {
            ar[cur.y][cur.x] = m;
            if (m >= n) {
                break;
            }
            cur = getNextPos(ar, cur);
            m++;
        }
        showArray(ar);
    }

    protected Pos getNextPos(int[][] ar, Pos cur) {
        Pos t = new Pos(cur);
        t.x += t.dx;
        t.y += t.dy;
        if (t.x >= 0 && t.x < col && t.y >= 0 && t.y < row && ar[t.y][t.x] == 0) {
            return t;
        } else {
            t = changeDirection(cur);
            return getNextPos(ar, t);
        }
    }

    protected Pos changeDirection(Pos p) {
        Pos t = new Pos(p);
        if (p.dx == 0 && p.dy == 1) {
            t.dx = 1;
            t.dy = 0;
        } else if (p.dx == 1 && p.dy == 0) {
            t.dx = 0;
            t.dy = -1;
        } else if (p.dx == 0 && p.dy == -1) {
            t.dx = -1;
            t.dy = 0;
        } else if (p.dx == -1 && p.dy == 0) {
            t.dx = 0;
            t.dy = 1;
        }
        return t;
    }

    protected Pos initPos() {
        return new Pos(0, 0, 1, 0);
    }
}

class MyMat extends Mat {


    @Override
    protected Pos changeDirection(Pos p) {
//        return super.changeDirection(p);
        Pos t = new Pos(p);
        if (p.dx == 0 && p.dy == 1) {
            t.dx = -1;
            t.dy = 0;
        } else if (p.dx == 1 && p.dy == 0) {
            t.dx = 0;
            t.dy = 1;
        } else if (p.dx == 0 && p.dy == -1) {
            t.dx = 1;
            t.dy = 0;
        } else if (p.dx == -1 && p.dy == 0) {
            t.dx = 0;
            t.dy = -1;
        }
        return t;
    }


    protected Pos initPos() {
        return new Pos(0, 0, 0, 1);
    }
}
