package com.iflytek.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yings
 * @create 2023-01-09 9:49
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode5 node4 = new ListNode5(1, null);
        ListNode5 node3 = new ListNode5(2);
        ListNode5 node2 = new ListNode5(2, node3);
        ListNode5 node1 = new ListNode5(1, node2);
        node3.next=node1;
        boolean res = hasCycle4(node1);
        System.out.println("res = " + res);
    }

    /**
     * 快慢指针法
     * 判断链表是否有环应该是老生常谈的一个话题了，最简单的一种方式就是快慢指针，慢指针针每次走一步，
     * 快指针每次走两步，如果相遇就说明有环，如果有一个为空说明没有环。代码比较简单
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode5 head) {
        if (head == null) {
            return false;
        }
        //快慢两个指针
        ListNode5 fast = head;
        ListNode5 slow = head;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            //如果相遇，说明有环，直接返回true
            if (slow == fast) {
                return true;
            }
        }
        //否则就是没环
        return false;
    }

    /**
     * 用集合来解决
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode5 head){
        Set<ListNode5> set=new HashSet<>();
        while (head!=null){
            //如果重复出现说明有环
            if (set.contains(head)){
                return true;
            }
            //否则就把当前节点加入到集合中
            set.add(head);
            head=head.next;
        }
        return false;
    }

    /**
     * 逐个删除
     * @param head
     * @return
     */
    public static boolean hasCycle3(ListNode5 head){
        //如果head为空，或者他的next指向为空，直接返回false
        if (head==null||head.next==null){
            return false;
        }
        //如果出现head.next = head表示有环
        if (head.next==head){
            return true;
        }

        ListNode5 nextNode=head.next;
        //当前节点的next指向他自己，相当于把它删除了
        head.next=head;
        //然后递归，查看下一个节点
        return hasCycle3(nextNode);
    }

    public static ListNode5 reverseList(ListNode5 head){
        //新链表
        ListNode5 newHead=null;
        while (head!=null){
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode5 tmp=head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next=newHead;
            //更新新链表
            newHead=head;
            //重新赋值，继续访问
            head=tmp;
        }
        return newHead;
    }
    public static boolean hasCycle4(ListNode5 head){
        ListNode5 rev=reverseList(head);
        if (head!=null&&head.next!=null&&rev==head){
            return true;
        }
        return false;
    }
}

class ListNode5 {
    int val;
    ListNode5 next;

    ListNode5(int val,ListNode5 next) {
        this.val = val;
        this.next = next;
    }

    public ListNode5(int val) {
        this.val = val;
    }
}