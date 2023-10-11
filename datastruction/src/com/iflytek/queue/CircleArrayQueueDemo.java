package com.iflytek.queue;

import java.util.Scanner;

/**
 * @author yings
 * @create 2022-02-06 15:15
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个环形队列
        //设置3, 其队列的有效数据最大是2
        CircleArrayQueue queue = new CircleArrayQueue(3);
        // 接收用户输入
        char key;
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(showQueue): 显示队列");
            System.out.println("a(enQueue): 添加数据到队列");
            System.out.println("g(deQueue): 从队列取出数据");
            System.out.println("h(getHead): 查看队列头的数据");
            System.out.println("e(exit): 退出程序");
            key = sc.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = sc.nextInt();
                    queue.enQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.deQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        //打印自己写的错误信息
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.getHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}

class CircleArrayQueue {
    private int maxSize;// 表示数组的最大容量
    private int front;//front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素,front 的初始值 = 0
    private int rear;//rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定,rear 的初始值 = 0
    private int[] arr;// 该数据用于存放数据, 模拟队列

    //初始化
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void enQueue(int num) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = num;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 判断队列是否空
    public int deQueue() {
        // 通过抛出异常
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能出队");
        }
        //因为 front 是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量 ,因为front之后会变动
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //从 front 开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            //因为i会随着一直增长，为了循环还要取模
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据， 注意不是取出数据
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

}
