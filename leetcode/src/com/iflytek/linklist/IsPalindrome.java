package com.iflytek.linklist;

import java.util.List;
import java.util.Stack;

/**
 * @author yings
 * @create 2022-09-10 15:49
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode4 node4 = new ListNode4(1, null);
        ListNode4 node3 = new ListNode4(2, node4);
        ListNode4 node2 = new ListNode4(2, node3);
        ListNode4 node1 = new ListNode4(1, node2);
        boolean isPalindrome = isPalindrome3(node1);
        System.out.println("isPalindrome = " + isPalindrome);

        printLinkReverse(node1);
    }

    /**
     * 反转后半部分链表
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode4 head) {
        ListNode4 fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

    //反转链表
    public static ListNode4 reverse(ListNode4 head) {
//        ListNode4 prev=null;
//        while (head!=null){
//            ListNode4 next=head.next;
//            head.next=prev;
//            prev=head;
//            head=next;
//        }
//        return head;
        ListNode4 prev = null;
        ListNode4 curr = head;
        while (curr != null) {
            ListNode4 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 使用栈来解决
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode4 head) {
        ListNode4 tmp = head;
        Stack<Integer> stack = new Stack<>();
        //把链表节点的值存放到栈中
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        //然后再出栈
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 使用栈来解决 改进版
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome22(ListNode4 head) {
        if (head == null) {
            return true;
        }
        ListNode4 tmp = head;
        Stack<Integer> stack = new Stack<>();
        //链表的长度
        int len = 0;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
            len++;
        }
        //len长度除以2
        len >>= 1;
        while (len-- >= 0) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void printLinkReverse(ListNode4 head) {
//        if (head!=null){
//            printLinkReverse(head.next);
//            System.out.println(head.val);
//        }

        if (head == null) {
            return;
        }
        printLinkReverse(head.next);
        System.out.println(head.val);
    }

    /**
     * 递归来解决
     */
    static ListNode4 tmp;
    public static boolean isPalindrome3(ListNode4 head){
        tmp=head;
        return check(head);

    }
    public static boolean check(ListNode4 head){
        if (head==null){
            return true;
        }
        boolean res=check(head.next)&&(tmp.val==head.val);
        tmp=tmp.next;
        return res;
    }
}

class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4(int val) {
        this.val = val;
    }

    ListNode4(int val, ListNode4 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode4{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
