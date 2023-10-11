package com.iflytek.linklist;

import java.util.Stack;


public class LinkDemo {

    //1) 求单链表中有效节点的个数
    public static int getNodesNum(SingleLinkList linkList) {
        int length = 0;//定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode head = linkList.getHead();
        if (head.next == null) {//空链表
            System.out.println("空链表");
            return 0;
        }
        HeroNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中的倒数第 k 个结点
    //1. 编写一个方法，接收 head 节点，同时接收一个 index
    // 2. index 表示是倒数第 index 个节点
    // 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    // 4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    // 5. 如果找到了，则返回该节点，否则返回 nulll
    public static HeroNode getReNodes(SingleLinkList linkList, int index) {
        HeroNode head = linkList.getHead();
        if (head.next == null) {//判断如果链表为空，返回 null
            System.out.println("空链表");
            return null;
        }
        HeroNode cur = head;
        //第一个遍历得到链表的长度(节点个数)
        int length = getNodesNum(linkList);
        //第二次遍历 size-index 位置，就是我们倒数的第K个节点
        // 先做一个 index 的校验
        if (index < 0 || index > length) {
            System.out.println("输入数据有误");
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的 index
        for (int i = 0; i <= length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //单链表的反转
    //思路就是新建一个链表，遍历原来的链表，用前插法插入到新的链表中
    public static SingleLinkList reverse(SingleLinkList linkList) {
        //原链表的头节点
        HeroNode head = linkList.getHead();
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return linkList;
        }
        SingleLinkList newLinklist = new SingleLinkList();
        HeroNode newHead = newLinklist.getHead();
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;//必须从这里获取当前，如果从循环里获得 .next.next,循环里又.next
        // 指向当前节点[cur]的下一个节点
        HeroNode next = null;
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
        while (cur != null) {

            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = newHead.next;//将 cur 的下一个节点指向新的链表的最前端
            newHead.next = cur;//将 cur 连接到新的链表上
            cur = next;//让 cur 后移
        }
        return newLinklist;
    }

    //4) 从尾到头打印单链表
    //1、将单链表反转操作，然后再遍历即可，这样做的问题会破坏原来的单链表结构，不建议
    //2、可以使用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出这个特点，实现逆序打印
    public static void reversePrint(SingleLinkList linkList) {
        HeroNode head = linkList.getHead();
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            //将链表的所有节点压入栈
            stack.add(cur);
            cur = cur.next;
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //合并两个有序的单链表，合并之后的链表依然有序
    public static SingleLinkList combineLinkList(SingleLinkList linkList1, SingleLinkList linkList2) {
        //原链表的头节点
        HeroNode head1 = linkList1.getHead();
        HeroNode head2 = linkList2.getHead();

        SingleLinkList newLinklist = new SingleLinkList();

        //如果两个链表为空，直接返回
        if (head1.next == null && head2.next == null) {
            return newLinklist;
        }

        HeroNode newHead = newLinklist.getHead();
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur1 = head1.next;//必须从这里获取当前
        HeroNode cur2 = head2.next;//必须从这里获取当前
        // 指向当前节点[cur]的下一个节点
//        HeroNode next = null;
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
        //这是前插
        /*
        while (cur1 != null && cur2 != null) {
            if (cur1.id <= cur2.id) {
                next = cur1.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
                cur1.next = newHead.next;//将 cur1 的下一个节点指向新的链表的最前端
                newHead.next = cur1;//将 cur1 连接到新的链表上
                cur1 = next;//让 cur1 后移
            } else {
                next = cur2.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
                cur2.next = newHead.next;//将 cur2 的下一个节点指向新的链表的最前端
                newHead.next = cur2;//将 cur2 连接到新的链表上
                cur2 = next;//让 cur2 后移
            }

        }
        while (cur1 != null) {
            next = cur1.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur1.next = newHead.next;//将 cur1 的下一个节点指向新的链表的最前端
            newHead.next = cur1;//将 cur1 连接到新的链表上
            cur1 = next;//让 cur1 后移
        }
        while (cur2 != null) {
            next = cur2.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur2.next = newHead.next;//将 cur2 的下一个节点指向新的链表的最前端
            newHead.next = cur2;//将 cur2 连接到新的链表上
            cur2 = next;//让 cur2 后移
        }
        */

        //后插法
        HeroNode r = newHead;//新链表的头指针不动

        while (cur1 != null && cur2 != null) {//全部为空就遍历
            if (cur1.id <= cur2.id) {//按从小到大顺序
                r.next=cur1;
                r=r.next;//r指针要指向当前节点
                cur1 = cur1.next;
            } else {
                r.next=cur2;
                r=r.next;
                cur2 = cur2.next;
            }
        }
        while (cur1!=null){
            r.next=cur1;
            r=r.next;
            cur1 = cur1.next;
        }
        while (cur2!=null){
            r.next=cur2;
            r=r.next;
            cur2 = cur2.next;
        }
        return newLinklist;

    }

    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "张三", "小张");
        HeroNode hero2 = new HeroNode(2, "李四", "小李");
        HeroNode hero3 = new HeroNode(3, "王五", "小王");
        HeroNode hero4 = new HeroNode(4, "刘六", "小刘");

//        SingleLinkList linkList = new SingleLinkList();
//        linkList.addHeroNode(hero1);
//        linkList.addHeroNode(hero3);
//        linkList.addHeroNode(hero2);
//        linkList.addHeroNode(hero4);
//
//        linkList.showLinkList();
//        System.out.println();
//        System.out.println(getNodesNum(linkList));
//        System.out.println(getReNodes(linkList,4));
//        System.out.println(getReNodes(linkList,2));
//        System.out.println(getReNodes(linkList,3));
//        System.out.println(getReNodes(linkList,1));

//        reverse(linkList).showLinkList();
//        System.out.println();
//        reversePrint(linkList);


        SingleLinkList linkList1 = new SingleLinkList();
        SingleLinkList linkList2 = new SingleLinkList();
//        linkList1.addHeroNode(hero1);
//        linkList1.addHeroNode(hero4);
//        linkList2.addHeroNode(hero2);
//        linkList2.addHeroNode(hero3);
        combineLinkList(linkList1, linkList2).showLinkList();
    }
}
