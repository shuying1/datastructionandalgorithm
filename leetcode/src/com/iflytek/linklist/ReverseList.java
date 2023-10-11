package com.iflytek.linklist;

import java.util.Stack;

/**
 * @author yings
 * @create 2022-09-10 9:03
 */
public class ReverseList {
    public static void main(String[] args) {

        ListNode2 node4 = new ListNode2(4, null);
        ListNode2 node3 = new ListNode2(3, node4);
        ListNode2 node2 = new ListNode2(2, node3);
        ListNode2 node1 = new ListNode2(1, node2);

        ListNode2 reverseList = reverseList2(node1);
        while (reverseList!=null){
            System.out.println(reverseList);
            reverseList=reverseList.next;
        }


    }

    /**
     * 双链表解决，每次访问原链表的头节点都会变成新链表的头节点
     *
     * @param head
     * @return
     */
    public static ListNode2 reverseList(ListNode2 head) {
        if (head == null) {
            return null;
        }
        //新链表
        ListNode2 newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode2 tmp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表 注意原链表已近断开了
            newHead = head;
            //重新赋值，继续访问
            head = tmp;
        }
        return newHead;
    }

    /**
     * 使用栈来解决
     * @param head
     * @return
     */
    public static ListNode2 reverseList2(ListNode2 head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode2> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode2 node = stack.pop();
        ListNode2 dummy = node;
        while (!stack.isEmpty()) {
            ListNode2 tmpNode = stack.pop();
            node.next = tmpNode;
            node = node.next;
        }


        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;

    }

    /**
     * 递归解决
     * @param head
     * @return
     */
    public static ListNode2 reverseList3(ListNode2 head) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存当前节点的下一个结点
        ListNode2 next = head.next;
        //从当前节点的下一个结点开始递归调用
        ListNode2 reverse = reverseList3(next);
        // reverse是反转之后的链表，因为函数reverseList
        // 表示的是对链表的反转，所以反转完之后next肯定
        // 是链表reverse的尾结点，然后我们再把当前节点
        // head挂到next节点的后面就完成了链表的反转。
        next.next = head;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        head.next = null;
        return reverse;
    }

}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode2{" +
                "val=" + val +
                '}';
    }
}
