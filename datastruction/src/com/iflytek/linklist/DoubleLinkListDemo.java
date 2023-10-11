package com.iflytek.linklist;

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int id;
    public String name;
    public String nickname;
    public HeroNode2 next;// 指向下一个节点, 默认为 null
    public HeroNode2 pre;// 指向前一个节点, 默认为 null

    // 构造器
    public HeroNode2(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

// 创建一个双向链表的类
class DoubleLinkList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void showList() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }

    }

    // 添加一个节点到双向链表的最后.
    public void addHeroNode(HeroNode2 heroNode) {
        // 因为 head 节点不能动，因此我们需要一个辅助遍历
        HeroNode2 temp = head;
        while (temp.next != null) {
            // 如果没有找到最后, 将将 temp 后移
            temp = temp.next;
        }
        //当退出while 循环时，temp 就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrderNode(HeroNode2 heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode2 tmp = head;
        while (tmp.next != null) {
            if (tmp.next.id > heroNode.id) {
                heroNode.next = tmp.next;
                tmp.next=heroNode;
                heroNode.pre=tmp;
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
        heroNode.next = tmp.next;
        tmp.next = heroNode;
        heroNode.pre=head;
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是节点类型改成 HeroNode2
    public void update(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空~");
        }
        // 找到需要修改的节点, 根据 no 编号
        // 定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;// 表示是否找到该节点
        while (temp != null) {
            if (temp.id == heroNode.id) {
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                flag = true;
            }
            //注意这里不能用else，只要不等就形成死循了，出不来
            temp = temp.next;

        }
        if (!flag) {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.id);
        }
    }

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int id) {
        // 判断当前链表是否为空
        if (head.next == null) {// 空链表
            System.out.println("链表为空，无法删除");
        }
        HeroNode2 temp = head.next; // 辅助变量(指针)
        boolean flag = false; // 标志是否找到待删除节点的
        while (temp!=null){
            if (temp.id==id){
                temp.pre.next=temp.next;
                // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
                if (temp.next!=null){
                    temp.next.pre=temp.pre;
                }
                flag = true;
            }
            temp=temp.next;

        }
        if (!flag){
            System.out.printf("要删除的 %d 节点不存在\n", id);
        }
    }
}

public class DoubleLinkListDemo {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkList doubleLinkedList = new DoubleLinkList();
//        doubleLinkedList.addHeroNode(hero1);
//        doubleLinkedList.addHeroNode(hero2);
//        doubleLinkedList.addHeroNode(hero3);
//        doubleLinkedList.addHeroNode(hero4);

        doubleLinkedList.addByOrderNode(hero1);
        doubleLinkedList.addByOrderNode(hero4);
        doubleLinkedList.addByOrderNode(hero4);
        doubleLinkedList.addByOrderNode(hero2);

        doubleLinkedList.showList();
        // 修改
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(newHeroNode);
//        System.out.println("修改后的链表情况");
//        doubleLinkedList.showList();
//        // 删除
//        doubleLinkedList.del(1);
//        System.out.println("删除后的链表情况~~");
//        doubleLinkedList.showList();

    }
}

