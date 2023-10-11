package com.iflytek.linklist;

/**
 * @author yings
 * @create 2022-09-10 14:55
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode3 linked13=new ListNode3(4,null);
        ListNode3 linked12=new ListNode3(2,linked13);
        ListNode3 linked11=new ListNode3(1,linked12);

        ListNode3 linked23=new ListNode3(4,null);
        ListNode3 linked22=new ListNode3(3,linked23);
        ListNode3 linked21=new ListNode3(1,linked22);

        ListNode3 resList = mergeTwoLists(linked11, linked21);
        System.out.println(resList);


    }

    public static ListNode3 mergeTwoLists(ListNode3 linked1, ListNode3 linked2) {
        //下面4行是空判断
        if (linked1 == null) {
            return linked2;
        }
        if (linked2 == null) {
            return linked1;
        }
        ListNode3 dummy = new ListNode3(0);
        ListNode3 curr = dummy;
        while (linked1 != null && linked2 != null) {
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = linked1 == null ? linked2 : linked1;
        return dummy.next;
    }

    public static ListNode3 mergeTwoLists2(ListNode3 linked1, ListNode3 linked2) {
        //下面4行是空判断
        if (linked1 == null) {
            return linked2;
        }
        if (linked2 == null) {
            return linked1;
        }
        if (linked1.val <= linked2.val) {
            linked1.next = mergeTwoLists(linked1.next, linked2);
            return linked1;
        } else {
            linked2.next = mergeTwoLists(linked1, linked2.next);
            return linked2;
        }
    }

    public static ListNode3 mergeTwoLists4(ListNode3 linked1, ListNode3 linked2) {
        //只要有一个为空，就返回另一个
        if (linked1 == null || linked2 == null) {
            return linked1 == null ? linked2 : linked1;
        }
        //把小的赋值给first
        ListNode3 first = (linked2.val > linked1.val) ? linked1 : linked2;
        first.next = mergeTwoLists4(first.next, first == linked2 ? linked1 : linked2);
        return first;
    }
}

class ListNode3 {
    int val;
    ListNode3 next;


    public ListNode3(int val) {
        this.val = val;
    }

    public ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode3{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
