package com.iflytek.stack;


//定义链表的节点
class Node{
    public int num;
    public Node next;

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }
}
//构建链表的战
class LinkStack{
    private Node head=new Node(-1);
    //判断是否为空
    public boolean isEmpty(){
        return head.next==null;
    }
    //这里采用头插法
    public void push(Node node){
        if (head.next==null){
            head.next=node;
            return;//注意要return 因为新创建的节点的next都为null，不退第一个节点后永续添加
        }
        node.next=head.next;
        head.next=node;
    }
    //出栈
    public void pop(){
        if (head.next==null){
            System.out.println("栈为空！不能出栈！");
        }
        System.out.println(head.next+"出栈");
        head=head.next;
    }
    //显示栈
    public void showLinkList(){
        if (isEmpty()){
            System.out.println("栈为空");
        }
        Node tmp=head.next;
        while (tmp!=null){
            System.out.println("节点为 "+tmp);
            tmp=tmp.next;
        }
    }
}
public class LinkStackDemo {
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        LinkStack linkStack=new LinkStack();
        linkStack.push(node1);
        linkStack.push(node2);
        linkStack.push(node3);
        linkStack.push(node4);
        linkStack.showLinkList();
        linkStack.pop();
        System.out.println("出栈后");
        linkStack.showLinkList();
    }
}
