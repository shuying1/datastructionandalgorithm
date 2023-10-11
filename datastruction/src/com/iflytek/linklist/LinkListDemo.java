package com.iflytek.linklist;

/**
 * @author yings
 * @create 2022-02-06 22:39
 */

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点的对象

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方法，我们重新 toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}

//定义 SingleLinkedList 管理我们的英雄
class SingleLinkList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表 ,尾插法
    // 思路，当不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的 next 指向 新的节点
    public void addHeroNode(HeroNode heroNode) {
        //因为 head 节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode tmp = head;
        //遍历链表
        while (tmp.next != null) {
            //如果没有找到最后, 将将 temp 后移
            tmp = tmp.next;
        }
        //当退出while 循环时，temp 就指向了链表的最后
        // 将最后这个节点的 next 指向 新的节点
        tmp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrderNode(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.id > heroNode.id) {
                heroNode.next = tmp.next;
                tmp.next = heroNode;
                return;
            } else if (tmp.next.id == heroNode.id) {//说明希望添加的 heroNode 的编号已然存在
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.id);
                return;
            } else {//tmp.next.id < heroNode.id 的情况
                tmp = tmp.next;
            }
        }
        //当退出while 循环时，temp 就指向了链表的最后
        // 将最后这个节点的 next 指向 新的节点
        tmp.next = heroNode;
    }

    //显示链表[遍历]
    public void showLinkList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            //return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode tmp = head;
        while (tmp.next != null) {
            //输出节点的信息
            System.out.println(tmp.next);
            //将 temp 后移， 一定小心
            tmp = tmp.next;
        }
    }

    //修改节点的信息, 根据 no 编号来修改，即 no 编号不能改.
    public void updateNode(HeroNode newHeroNode) {
        //找到需要修改的节点, 根据 no 编号
        // 定义一个辅助变量
        HeroNode tmp = head;
        if (tmp.next==null){
            System.out.println("链表为空~");
        }
        boolean flag=false;
        while (tmp.next != null) {
            if (tmp.id == newHeroNode.id) {
                tmp.name = newHeroNode.name;
                tmp.nickName = newHeroNode.nickName;
                flag=true;
            }
            //注意这里不能用else，只要不等就形成死循了，出不来
            tmp=tmp.next;
        }
        //没有找到
        if (!flag){
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.id);
        }

    }

    //删除节点
    //1. head 不能动，因此我们需要一个 temp 辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是 temp.next.id 和 需要删除的节点的 id 比较
    public void delNode(int id) {
        HeroNode tmp=head;
        boolean flag=false;
        while (tmp.next!=null){
            if (tmp.next.id==id){//找到的待删除节点的前一个节点 tmp
                tmp.next = tmp.next.next;
                flag=true;
                return;
            }
            tmp=tmp.next;
        }
        if (!flag){
            System.out.printf("要删除的 %d 节点不存在\n", id);

        }
    }
}

public class LinkListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "张三", "小张");
        HeroNode hero2 = new HeroNode(2, "李四", "小李");
        HeroNode hero3 = new HeroNode(3, "王五", "小王");
        HeroNode hero4 = new HeroNode(4, "刘六", "小刘");

        SingleLinkList linkList = new SingleLinkList();
        //加入
//        linkList.addHeroNode(hero1);
//        linkList.addHeroNode(hero2);
//        linkList.addHeroNode(hero3);
//        linkList.addHeroNode(hero4);
        //加入按照编号的顺序
        linkList.addByOrderNode(hero1);
        linkList.addByOrderNode(hero3);
        linkList.addByOrderNode(hero2);
        linkList.addByOrderNode(hero4);

        linkList.showLinkList();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        linkList.updateNode(newHeroNode);

        System.out.println("修改后的链表情况~~");
        linkList.showLinkList();


        linkList.delNode(1);
        linkList.delNode(4);
//        linkList.addByOrderNode(hero2);
        linkList.addHeroNode(hero2);//不能是同一个对象，会形成死循环，因为实在末尾插入的，内存地址相同
//        HeroNode hero5=new HeroNode(5,"宋江","小宋");
//        linkList.addHeroNode(hero5);

        System.out.println();
        linkList.showLinkList();
    }

}
