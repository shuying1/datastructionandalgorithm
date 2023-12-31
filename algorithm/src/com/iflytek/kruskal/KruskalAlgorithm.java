package com.iflytek.kruskal;


import java.util.Arrays;

/**
 * @author yings
 * @create 2022-08-03 10:50
 */
public class KruskalAlgorithm {
    private int edgeNum;//边的个数
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    //构造器
    public KruskalAlgorithm(char[] vertex, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertex.length;
        //初始化顶点, 复制拷贝的方式
        this.vertex = new char[vlen];

        for (int i = 0; i < vlen; i++) {
            this.vertex[i] = vertex[i];
        }
        //初始化边, 使用的是复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边的条数
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存"已有最小生成树" 中的每个顶点在最小生成树中的终点
        //创建结果数组, 保存最后的最小生成树
        EData[] rets = new EData[edgeNum];
        //获取图中 所有的边的集合 ， 一共有 12 边
        EData[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共" + edges.length); //12
        //按照边的权值大小进行排序(从小到大)
        sortEdges(edges);
        //遍历 edges 数组，将边添加到最小生成树中时，判断是准备加入的边否形成了回路，如果没有，就加入 rets,否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第 i 条边的第一个顶点(起点)
            int p1 = getPosition(edges[i].start);
            //获取到第 i 条边的第 2 个顶点
            int p2 = getPosition(edges[i].end);
            //获取 p1 这个顶点在已有最小生成树中的终点
            int m =getEnd(ends,p1);
            //获取 p2 这个顶点在已有最小生成树中的终点
            int n=getEnd(ends,p2);
            //是否构成回路
            if (n!=m){//没有构成回路
                ends[m]=n; // 设置m 在"已有最小生成树"中的终点 <E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                rets[index++]=edges[i];//有一条边加入到 rets 数组
            }
        }
        //<E,F> <C,D> <D,E> <B,F> <E,G> <A,B>。
        // 统计并打印 "最小生成树", 输出 rets
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }

    /**
     * 功能: 获取下标为 i 的顶点的终点(), 用于后面判断两个顶点的终点是否相同
     * @param ends 数组就是记录了各个顶点对应的终点是哪个,ends 数组是在遍历过程中，逐步形成
     * @param i 表示传入的顶点对应的下标
     * @return 返回的就是 下标为 i 的这个顶点对应的终点的下标, 一会回头还有来理解
     */
    private int getEnd(int[] ends, int i) {// i = 4 [0,0,0,0,5,0,0,0,0,0,0,0]
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

    /**
     * 功能: 获取图中边，放到 EData[] 数组中，后面我们需要遍历该数组
     * 是通过matrix 邻接矩阵来获取
     * EData[] 形式 [['A','B', 12], ['B','F',7], .....]
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * @param ch 顶点的值，比如'A','B'
     * @return 返回 ch 顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == ch) {//找到
                return i;
            }
        }
        //找不到,返回-1
        return -1;
    }

    /**
     * 功能：对边进行排序处理, 冒泡排序
     *
     * @param edges 边的集合
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();//换行
        }
    }

    public static void main(String[] args) {
        char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalAlgorithm kruskalAlgorithm=new KruskalAlgorithm(vertex,matrix);
        kruskalAlgorithm.print();
        kruskalAlgorithm.kruskal();
    }



}


//创建一个类 EData ，它的对象实例就表示一条边
class EData {
    char start;//边的一个点
    char end;//边的另外一个点
    int weight;//边的权值

    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //重写 toString, 便于输出边信息

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}