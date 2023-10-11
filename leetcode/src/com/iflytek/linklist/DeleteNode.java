package com.iflytek.linklist;

/**
 * @author yings
 * @create 2022-09-03 22:45
 */
public class DeleteNode {
    public static void main(String[] args) {
        LinkNode linkNode1 = new LinkNode(4);
        LinkNode linkNode2 = new LinkNode(1);
        LinkNode linkNode3 = new LinkNode(5);
        LinkNode linkNode4 = new LinkNode(9);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        System.out.println(linkNode1);
        deleteNode(linkNode3);
        System.out.println(linkNode1);


    }

    public static void deleteNode(LinkNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class LinkNode {
    int val;
    LinkNode next;

    public LinkNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "LinkNode " +
                "val=" + val +
                ", next->" + next
                ;
    }
}

