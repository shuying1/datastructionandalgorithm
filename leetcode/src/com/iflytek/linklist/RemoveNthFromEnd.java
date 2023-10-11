package com.iflytek.linklist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yings
 * @create 2022-09-05 17:10
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(listNode1);
        ListNode resHead = removeNthFromEnd4(listNode1, 5);
        System.out.println(resHead);
    }

    /**
     * 找到倒数第n个节点的前一个节点，为length-n-1，后面双指针就是根据这个长度来的
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int removeIndex = length2(head) - n;
        //表示删除的是头节点
        if (removeIndex == 0) {
            return head.next;
        }
        //这里首先要找到要删除链表的前一个结点
        for (int i = 0; i < removeIndex - 1; i++) {
            pre = pre.next;
        }
        //然后让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 求链表的长度  非递归
     *
     * @param head
     * @return
     */
    public static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    //递归解决
    public static int length2(ListNode head) {
        if (head == null) {
            return 0;
        }
        return length2(head.next) + 1;

    }

    // 双指针解决，第一个指针先向前走n步，然后第二个指针从头节点开始，则当第一个
// 指针走到末尾时，第二个指针走了lenght-n-1步
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = head, last = head;
        //first移n步
        int i = 0;
        while (i < n) {
            first = first.next;
            i++;
        }
        //如果first为空，表示删除的是头结点
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            last = last.next;
        }
        //这里最终last不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        last.next = last.next.next;
        return head;
    }

    /**
     * 不考虑头节点的问题
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head, last = dummy;
        //first移n步
        int i = 1;
        while (i < n) {
            first = first.next;
            i++;
        }

        while (first.next != null) {
            first = first.next;
            last = last.next;
        }

        last.next = last.next.next;
        return dummy.next;
    }

    // 双端队列当作栈来处理  https://www.cainiaojc.com/java/java-deque.html
    public static ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        // Deque 为一个接口，可以看成是一个双端队列
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);// 在Deque的头部添加元素
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
