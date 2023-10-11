package com.iflytek.hashtable;

import java.util.Scanner;

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//next 默认为 null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建 EmpLinkedList ,表示链表
class EmpLinkedList {
    //头指针，执行第一个 Emp,因此我们这个链表的 head 是直接指向第一个 Emp
    private Emp head;//默认 null

    //添加雇员到链表
    //1. 假定，当添加雇员时，id 是自增长，即 id 的分配总是从小到大
    // 因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;//退出
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {//说明到链表最后
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //退出时直接将 emp 加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {//说明链表为空
            System.out.println("第" + (no + 1) + "个链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 个链表的信息为");
        Emp curEmp = head;
        while (curEmp != null) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
//       add
        System.out.println();
    }

    //根据 id 查找雇员, 如果查找到，就返回 Emp, 如果没有找到，就返回 null
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (curEmp != null) {
            if (id == curEmp.id) {
                break;//这时 curEmp 就指向要查找的雇员
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }
}

//创建HashTab 管理多条链表
class HashTable {
    private int size;//表示有多少条链表
    private EmpLinkedList[] empLinkedArrays;

    public HashTable(int size) {
        this.size = size;
        //初始化 empLinkedListArray
        empLinkedArrays = new EmpLinkedList[size];
        //？留一个坑, 这时要不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedArrays[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //编写散列函数, 使用一个简单取模法
        //根据员工的 id ,得到该员工应当添加到哪条链表
        int empLinkedListNo = emp.id % size;
        //将 emp 添加到对应的链表中
        empLinkedArrays[empLinkedListNo].add(emp);
    }

    //遍历所有的链表,遍历 hashtable
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedArrays[i].list(i);
        }
    }

    //根据输入的 id,查找雇员
    public void findEmpById(int id) {
        //编写散列函数, 使用一个简单取模法
        //根据员工的 id ,得到该员工应当添加到哪条链表
        int empLinkedListNo = id % size;
        Emp emp = empLinkedArrays[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d 条链表中找到 雇员 id = %d\n", (empLinkedListNo + 1), id);
        } else {
            System.out.println("在HashTable中没有找到该雇员");
        }

    }

}

public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        //写一个简单的菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名字");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入你要查找的id");
                    id = sc.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}