package com.iflytek.linklist;


// 创建一个 Boy 类，表示一个节点
class Boy {
    public int no;// 编号
    public Boy next;// 指向下一个节点,默认 null

    public Boy(int no) {
        this.no = no;
    }
}

// 创建一个环形的单向链表
class CircleSingleLinkList {
    // 创建一个 first 节点,当前没有编号
    private Boy first = null;

    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }
        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        // 使用 for 来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.next = boy;// 构成环
                curBoy = first;// 让 curBoy 指向第一个小孩
            } else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }
        }
    }

    // 遍历当前的环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // 因为 first 不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (first != curBoy.next) {
            System.out.printf("小孩的编号 %d \n", curBoy.no);
            curBoy = curBoy.next;// curBoy 后移
        }
        //当只有一个节点时
        System.out.printf("小孩的编号 %d \n", curBoy.no);
    }

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || nums < startNo) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (helper.next!=first){
            helper=helper.next;
        }

//        while (true) {
//            if (helper.next == first) { // 说明 helper 指向最后小孩节点
//                break;
//            }
//            helper = helper.next;
//        }

        //小孩报数前，先让 first 和 helper 移动 k - 1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //当小孩报数时，让 first 和 helper 指针同时 的移动 m - 1 次, 然后出圈
        // 直到圈中只有一个节点
        //让 first 和 helper 指针同时 的移动 countNum - 1
        //注意一个问题，首先helper.next=first,当作循环判断不行
        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.no);
            //这时将 first 指向的小孩节点出圈
            first = first.next;
            helper.next = first;
        }

        System.out.printf("最后留在圈中的小孩编号%d \n", first.no);
    }
}

public class SingleCircleLinkListDemo {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否 ok
        CircleSingleLinkList circleSingleLinkedList = new CircleSingleLinkList();
        circleSingleLinkedList.addBoy(6);
        // 加入 5 个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 6); // 2->4->1->5->3
    }
}
