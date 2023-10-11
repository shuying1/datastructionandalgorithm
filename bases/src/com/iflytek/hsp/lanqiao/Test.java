package com.iflytek.hsp.lanqiao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author yings
 * @create 2023-02-20 12:10
 */
public class Test {


    public static void main(String[] args) throws ParseException {
//        String str = " hello world ";
//        System.out.println(str.toLowerCase());
//        System.out.println(str.toUpperCase());
//        System.out.println(Arrays.toString(str.toCharArray()));
//        System.out.println(str.trim());
//        System.out.println(str.charAt(0));
//        System.out.println(str.charAt(1));
//        System.out.println(str.charAt(2));
//        System.out.println(str.charAt(3));
//        System.out.println(str.substring(5));
//        System.out.println(str.indexOf('l'));

//        int[] array = {1, 2, 6, 7, 3, 9, 8};
//// 拷⻉数组
//        int[] arr1 = Arrays.copyOf(array, 2);//拷贝两个数
//        System.out.println(Arrays.toString(arr1));
////// 拷⻉
//        int[] arr2 = Arrays.copyOfRange(array, 1, 3);//不包括最后一个
//        System.out.println(Arrays.toString(arr2));
// 排序的结果是升序
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        Integer[] integers = {1, 2, 6, 7, 3, 9, 8};
//// 排序的结果是降序
//        Arrays.sort(integers, Collections.reverseOrder());
//        System.out.println(Arrays.toString(integers));
//        Integer[] array2 = {1, 2, 6, 7, 3, 9, 8};
////        Arrays.sort(array2, Collections.reverseOrder());
//        Arrays.sort(array2, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 02-01;
//            }
//        });
//
//        System.out.println(Arrays.toString(integers));


//        float num = -3.14f;
//        System.out.println(Math.abs(num));
//        //获取绝对值
//        System.out.println(Math.round(num));
//        //四舍五入
//        System.out.println((int) (Math.random()*10));
//        //获取随机数
//        System.out.println(Math.pow(2,3));
//        //计算次方
//        System.out.println(Math.ceil(num));
//        //向上取整
//        System.out.println(Math.floor(num));
//        //向下取整
//        System.out.println(Math.sqrt(2));
//        //计算平方根


//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        String date="2023-02-12";
//
//        Date date1 = new Date();
//        System.out.println(date1);
//        String formatDate1 = dateFormat.format(date1);
//        System.out.println(formatDate1);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateFormat.parse(date));
//        System.out.println(dateFormat.parse(date));

//数组
//        List<Integer> arrayList = new ArrayList<>();
////        链表
//        List<Integer> linkList = new LinkedList<>();
////双端队列
//        Deque<Integer> deque = new ArrayDeque<>();
////栈
//        Stack<Integer> stack = new Stack<>();
////哈希表底层是红黑树
//        Map<Integer, Integer> map = new HashMap<>();
////        集合底层是红黑树
//        Set<Integer> hashSet = new HashSet<>();
////支持排序的集合
//        Set<Integer> sortSet = new TreeSet<>();
////支持插入顺序的集合
//        Set<Integer> orderedSet = new HashSet<>();

//        Map<Integer,Integer> map=new HashMap<>();
//        //获取key为50的元素，如果不存在就添加
//        Integer orDefault = map.getOrDefault(50, 3);
//        System.out.println(orDefault);

//        RunningTrain();
//        RunningTrain2();
//        RunningTrain3();

//        zhengchuxulie();

//         String s = "1234";
//        printStringByRecursion(s);
//        System.out.println();
//        printStringByRecursion2(s);

//        Scanner scanner=new Scanner(System.in);
//        int n =scanner.nextInt();
//        System.out.println(fn(n));

//        dg(1234);
//        dg2(1234);


//        count();

//        fourPowOfSum(773535);

//        perfectCube(24);

//        shengLiZhouQi(4, 5, 6, 7);


//        boolean result = hasSameChar("a");
//        boolean res = hasSameChar("aa");
//        boolean result2 = hasSameChar("abcdefg");
//        boolean result3 = hasSameChar("abcdefga");
//        boolean result4 = hasSameChar("abcdcfa");
//        boolean result5 = hasSameChar("adsfdsasd");
//        System.out.println(result);
//        System.out.println(result2);
//        System.out.println(result3);
//        System.out.println(result4);
//        System.out.println(result5);
//        System.out.println(res);


//        int can[] = new int[6];
//        lever(5,0, 5, 121, can);

//        lever2();
//        lever3(5, 0, 0, "");


    }


    /**
     * 问题描述】
     * 小明要做一个跑步训练。
     * 初始时，小明充满体力，体力值计为 10000。如果小明跑步，每分钟损耗 600 的体力。如果小明
     * 休息，每分钟增加 300 的体力。体力的损耗和增加都是均匀变化的。
     * 小明打算跑一分钟、休息一分钟、再跑一分钟、再休息一分钟......如此循环。如果某个时刻小明的体
     * 力到达 0，他就停止锻炼。
     * 请问小明在多久后停止锻炼。为了使答案为整数，请以秒为单位输出答案。
     * 答案中只填写数，不填写单位。
     * 【答案提交】
     * 这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写
     * 这个整数，填写多余的内容将无法得分。
     */
    /**
     * 按秒模拟
     */
    public static void RunningTrain() {
        //体力值
        int energy = 10000;
        int consume = 10;
        int recovery = 5;
        int time = 0;
        while (true) {
            for (int i = 0; i < 60; i++) {
                //跑一秒钟消耗10
                energy -= 10;
                time++;
                if (energy <= 0) {
                    System.out.println("time=" + time);
                    return;
                }
            }
            energy += 300;
            time += 60;
        }

    }

    /**
     * 按分模拟
     */
    public static void RunningTrain2() {
        int N = 10000;
        int t = 0;
        while (N > 0) {
            N -= 300;
            t += 2;
            if (N - 600 < 0) {
                t = t * 60 + N / 10;
                System.out.println(t);
                return;
            }
        }

    }

    public static void RunningTrain3() {
        int N = 10000;
        int t = 0;
        while (N > 0) {
            for (int i = 0; i < 60; i++) {
                //不能这么写，因为在这里能量值有可能为0或为负数
                N -= 10;
                t++;
            }
            N += 300;
            t += 60;
        }
        System.out.println(t);
    }

    /**
     * 问题描述
     * 有一个序列，序列的第一个数是 n，后面的每个数是前一个数整除 2，请输
     * 出这个序列中值为正数的项。
     * 【输入格式】
     * 输入一行包含一个整数 n。
     * 【输出格式】
     * 输出一行，包含多个整数，相邻的整数之间用一个空格分隔，表示答案。
     * 【样例输入】
     * 20
     * 【样例输出】
     * 20 10 5 2 1
     * 【评测用例规模与约定】
     * 对于 80% 的评测用例，1 ≤ n ≤ 10^9。
     * 对于所有评测用例，1 ≤ n ≤ 10^18。
     */
    public static void zhengchuxulie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        long num = scanner.nextLong();
//        for (long i = num; i > 0; i = i / 2) {
//            System.out.print(i + " ");
//        }
        while (num != 0) {
            System.out.println(num + " ");
            num /= 2;
        }
    }

    /**
     * 按顺序输出数字字符串
     *
     * @param str
     */
    public static void printStringByRecursion(String str) {
        if (str == null || str.equals("") || str.length() == 1) {
            System.out.print(str);//这里很重要，没有换行输出
            return;
        }
        System.out.print(str.charAt(0) + " ");
        printStringByRecursion(str.substring(1));
    }

    /**
     * 按顺序倒序输出数字字符串
     *
     * @param str
     */
    public static void printStringByRecursion2(String str) {
        if (str == null || str.equals("") || str.length() == 1) {
            System.out.print(str);//这里很重要，没有换行输出
            return;
        }
        printStringByRecursion2(str.substring(1));
        System.out.print(" " + str.charAt(0));

    }

    public static int fn(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return fn(n - 1) + fn(n - 2);
        }
    }

    /**
     * 将 12345 输出为1 2 3 4 5
     */
    public static void dg(int num) {
        if (num / 10 == 0) {
            System.out.print(num + " ");
            return;
        } else {
//            num = num / 10; 如果这样进来num就/10了，少了一层递归调用
            dg(num / 10);
            System.out.print(num % 10 + " ");
        }
    }

    /**
     * 将 12345 输出为5 4 3 2 1
     */
    public static void dg2(int num) {
        if (num > 10) {
            System.out.print(num % 10 + " ");
            dg2(num / 10);
        } else {
            System.out.println(num);
            return;
        }
    }

    public static void count() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        System.out.println(list);

        for (; ; ) {
            if (list.size() == 1) {
                break;
            }
            for (int i = 0; i < 2; i++) {
                list.add(list.remove(0));//list.remove()返回了一个值
            }
            list.remove(0);
            System.out.println(list);
        }

    }

    /**
     * 判断字符串是否有重复的字符
     *
     * @param str
     * @return
     */
    public static boolean hasSameChar(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int k = str.lastIndexOf(c);

            if (k != i) {
                return true;
            }
        }
        return false;
    }

    public static void lever(int n, int result, int i, int sum, int can[]) {
        int temp[] = {0, 1, 3, 9, 27, 81};

        if (result == n) {
            for (int j = 5; j > 0; j--) {
                if (can[j] > 0) {
                    System.out.print("+" + can[j]);
                } else if (can[j] < 0) {
                    System.out.print(can[j]);
                }
            }
            System.out.println();
        } else if (result - sum > n) {
            return;
        } else {
            for (int j = i; j > 0; j--) {
                can[i] = temp[j];
                lever(n, result + temp[j], j - 1, sum -= temp[j], can);
                if (i == 5) {
                    continue;
                }
                can[i] = -temp[j];
                lever(n, result - temp[j], j - 1, sum, can);
                can[i] = 0;
            }
        }

    }

    public static void lever2() {

        int can[] = new int[5];
        //每个砝码有三种状态，要么相加，要么相减，要么啥也不干
        int a[] = {0, 1, -1};
        int b[] = {0, 3, -3};
        int c[] = {0, 9, -9};
        int d[] = {0, 27, -27};
        int e[] = {0, 81, -81};
        int h, i, j, k, m, n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                for (k = 0; k < 3; k++)
                    for (m = 0; m < 3; m++)
                        for (h = 0; h < 3; h++) {
                            if (a[i] + b[j] + c[k] + d[m] + e[h] == n) {
                                can[4] = a[i];
                                can[3] = b[j];
                                can[2] = c[k];
                                can[1] = d[m];
                                can[0] = e[h];
//                                因为正数放在最前面，所以最大的数放在最前面
                            }
                        }
        for (i = 0; i < 5; i++) {
            if (i == 0)
                System.out.print(can[i]);
            else if (can[i] > 0)
                System.out.print("+" + can[i]);
            else if (can[i] < 0)
                System.out.print(can[i]);

        }

    }

    public static void lever3(int n, int k, int sum, String ans) {
        int[] weight = {87, 21, 9, 3, 1};
        if (n == sum) {
            System.out.println(ans.substring(1));
        } else if (k < 5) {
            lever3(n, k + 1, sum + weight[k], ans + "+" + weight[k]);
            lever3(n, k + 1, sum, ans);
            lever3(n, k + 1, sum - weight[k], ans + "-" + weight[k]);

        }

    }

    /**
     * 四平方和 因为题目要求a<=b<=c<=d
     * 每个正整数都可以表示为至多4个正整数的平方和。
     * 　　如果把0包括进去，就正好可以表示为4个数的平方和。
     * <p>
     * 　　比如：
     * 　　5 = 0^2 + 0^2 + 1^2 + 2^2
     * 　　7 = 1^2 + 1^2 + 1^2 + 2^2
     * 　　（^符号表示乘方的意思）
     * <p>
     * 　　对于一个给定的正整数，可能存在多种平方和的表示法。
     * 　　要求你对4个数排序：
     * 　　0 <= a <= b <= c <= d
     * 　　并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法
     * <p>
     * <p>
     * 　　程序输入为一个正整数N (N<5000000)
     * 　　要求输出4个非负整数，按从小到大排序，中间用空格分开
     * <p>
     * 　　例如，输入：
     * 　　5
     * 　　则程序应该输出：
     * 　　0 0 1 2
     * <p>
     * 　　再例如，输入：
     * 　　12
     * 　　则程序应该输出：
     * 　　0 2 2 2
     * <p>
     * 　　再例如，输入：
     * 　　773535
     * 　　则程序应该输出：
     * 　　1 1 267 838
     *
     * @param num
     */
    public static void fourPowOfSum(int num) {
        int a, b, c, d;
        int upper = (int) Math.sqrt(num);
        for (a = 0; a < upper; a++) {
            for (b = a; b <= upper; b++) {//因为题目要求a<=b<=c<=d
                for (c = b; c <= upper; c++) {
                    //四层循环变三层
                    int temp = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
                    if (temp > Math.pow(num, 2)) {
                        break;
                    }
                    int d2 = num - temp;
                    d = (int) Math.sqrt(d2);
                    if (Math.pow(d, 2) == d2) {
                        System.out.println(a + " " + b + " " + c + " " + d + " ");
                        return;//这个直接满足a<=b<=c<=d 所以要返回
                    }
                }
            }
        }
    }

    /**
     * 形如a^3= b^3 + c^3 + d^3的等式被称为完美立方等式。例如123= 63 + 83 + 103 。
     * 编写一个程序，对任给的正整数N (N≤100)，寻找所有的四元组(a, b, c, d)，
     * 使得a3 = b3 + c3 + d3，其中a,b,c,d 大于 1, 小于等于N，且b<=c<=d。
     * 输入
     * 一个正整数N (N≤100)。
     * 输出
     * 每行输出一个完美立方。输出格式为：
     * Cube = a, Triple = (b,c,d)
     * 其中a,b,c,d所在位置分别用实际求出四元组值代入。
     * 请按照a的值，从小到大依次输出。当两个完美立方等式中a的值相同，
     * 则b值小的优先输出、仍相同则c值小的优先输出、再相同则d值小的先输出。
     * 样例输入
     * 24
     * Cube = 6, Triple = (3,4,5)
     * Cube = 12, Triple = (6,8,10)
     * Cube = 18, Triple = (2,12,16)
     * Cube = 18, Triple = (9,12,15)
     * Cube = 19, Triple = (3,10,18)
     * Cube = 20, Triple = (7,14,17)
     * Cube = 24, Triple = (12,16,20)
     */
    public static void perfectCube(int num) {
        int a, b, c, d;
//        技巧在后三层循环的范围 因为a是可以取到num的，bcd都要比a小
        for (a = 2; a <= num; a++) {
            for (b = 2; b < a; b++) {
                for (c = b; c < a; c++) {
                    for (d = c; d < a; d++) {
                        if (Math.pow(a, 3) == Math.pow(b, 3) + Math.pow(c, 3) + Math.pow(d, 3)) {
                            System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
                        }
                    }
                }

            }
        }
    }


    /**
     * 人生来就有三个生理周期，分别为体力、感情和智力周期，它们的周期长度为23天、28天和33天。
     * 每一个周期中有一天是高峰。在高峰这天，人会在相应的方面表现出色。例如，智力周期的高峰，
     * 人会思维敏捷，精力容易高度集中。因为三个周期的周长不同，所以通常三个周期的高峰不会落在同一天。
     * 对于每个人，我们想知道何时三个高峰落在同一天。对于每个周期，我们会给出从当前年份的第一天开始，
     * 到出现高峰的天数（不一定是第一次高峰出现的时间）。你的任务是给定一个从当年第一天开始数的天数，
     * 输出从给定时间开始（不包括给定时间）下一次三个高峰落在同一天的时间（距给定时间的天数）。
     * 例如：给定时间为10，下次出现三个高峰同天的时间是12，则输出2（注意这里不是3）。
     * <p>
     * 输入
     * 一行，包含四个整数：p, e, i和d，相邻两个整数之间用单个空格隔开。 p, e, i分别表示体力、情感和智力高峰出现的时间（时间从当年的第一天开始计算）。d 是给定的时间，可能小于p, e, 或 i。 所有给定时间是非负的并且小于等于365, 所求的时间小于等于21252。
     * 输出
     * 一个整数，即从给定时间起，下一次三个高峰同天的时间（距离给定时间的天数）。
     * 样例输入
     * 4 5 6 7
     * 样例输出
     * 16994
     *
     * @param p
     * @param e
     * @param i
     * @param d
     */
    public static void shengLiZhouQi(int p, int e, int i, int d) {
        int k;
        // 逐天尝试，找第一个（周期最短的）体力高峰
// (k - p) % 23 != 0 => 说明 k 不是体力高峰，for 循环停止说明找到下一个体力高峰
        for (k = d + 1; (k - p) % 23 != 0; k++) ;
        // 在确保是体力高峰的情况下跳着枚举，每次跳一个体力周期，找到下一个体力、感情双高峰
        // (k - e) % 28 != 0 => 说明 k 不是感情高峰，for 循环停止说明找到下一个体力、感情双高峰
        for (; (k - e) % 28 != 0; k += 23) ;
        for (; (k - i) % 33 != 0; k += (28*23)) ;
        System.out.println(k - d);
    }

    /**
     *  问题描述
     * 　　输入二个正整数x0,y0(2<=x0<=100000,2<=y0<=100000),求出满足下列条件的P,Q的个数
     * 　　条件: 1.P,Q是正整数
     * 　　2.要求P,Q以x0为最大公约数,以y0为最小公倍数.
     * 　　试求:满足条件的所有可能的两个正整数的个数.
     * @param a
     * @param b
     */
   public static void gcb(int a,int b){

   }

}
