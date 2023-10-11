package com.iflytek.tree;


public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode2 root = new HeroNode2(1, "tom");
        HeroNode2 node2 = new HeroNode2(3, "jack");
        HeroNode2 node3 = new HeroNode2(6, "smith");
        HeroNode2 node4 = new HeroNode2(8, "mary");
        HeroNode2 node5 = new HeroNode2(10, "king");
        HeroNode2 node6 = new HeroNode2(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree threadedBinaryTree = new ThreadBinaryTree();

        //测试中序线索化
/*        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.infixThreadBidNodes();
        System.out.println("node5 = " + node5);
        System.out.println("10 号结点的前驱结点是 =" + node5.getLeft());//3
        System.out.println("10 号结点的后继结点是=" + node5.getRight()); //1*/

        //测试前序线索化
       /* threadedBinaryTree.setRoot(root);
        threadedBinaryTree.preThreadBidNodes();
        System.out.println("node5 = " + node5);
        System.out.println("10 号结点的前驱结点是 =" + node5.getLeft());//3
        System.out.println("10 号结点的后继结点是=" + node5.getRight()); //1*/

        //测试后序线索化
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.postThreadBiNodes();
        System.out.println("node5 = " + node5);
        System.out.println("10 号结点的前驱结点是 =" + node5.getLeft());//3
        System.out.println("10 号结点的后继结点是=" + node5.getRight()); //1

        //threadedBinaryTree.infixThreadList(threadedBinaryTree.getRoot());
        //threadedBinaryTree.preThreadList(threadedBinaryTree.getRoot());
        threadedBinaryTree.postThreadList(threadedBinaryTree.getRoot());


    }
}

//定义 ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadBinaryTree {
    private HeroNode2 root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNode2 pre = null;

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }

    public HeroNode2 getRoot() {
        return root;
    }

    //重载一把 infixThreadedNodes 方法
    public void infixThreadBidNodes() {
        this.infixThreadBiNodes(root);
    }

    //重载一把 preThreadBiNodes 方法
    public void preThreadBidNodes() {
        this.preThreadBiNodes(root);
    }

    //重载一把 postTreadBiNodes 方法
    public void postThreadBiNodes() {
        this.postThreadBiNodes(root);
    }

    /**
     * @param node 就是当前需要线索化的节点
     */
    public void infixThreadBiNodes(HeroNode2 node) {
        //如果 node==null, 不能线索化
        if (node == null) {
            return;
        }
        //(一)先线索化左子树
        if (node.getLeftType() == 0) {
            infixThreadBiNodes(node.getLeft());
        }

        //处理当前结点的前驱结点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        if (node.getRightType() == 0) {
            infixThreadBiNodes(node.getRight());
        }

    }

    /**
     * @param node 就是当前需要线索化的节点
     */
    public void preThreadBiNodes(HeroNode2 node) {
        //如果 node==null, 不能线索化
        if (node == null) {
            return;
        }
        //处理当前结点的前驱结点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //(一)先线索化左子树
        if (node.getLeftType() == 0) {
            preThreadBiNodes(node.getLeft());
        }

        //(一)先线索化右子树
        if (node.getRightType() == 0) {
            preThreadBiNodes(node.getRight());
        }

    }

    /**
     * @param node 就是当前需要线索化的节点
     */
    public void postThreadBiNodes(HeroNode2 node) {
        //如果 node==null, 不能线索化
        if (node == null) {
            return;
        }
        //(一)先线索化左子树
        if (node.getLeftType() == 0) {
            postThreadBiNodes(node.getLeft());
        }

        //(一)先线索化右子树
        if (node.getRightType() == 0) {
            postThreadBiNodes(node.getRight());
        }

        //处理当前结点的前驱结点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

    }

    //中序遍历线索化二叉树的方法
    public void infixThreadList(HeroNode2 root) {
        //定义一个变量，存储当前遍历的结点，从 root 开始
        HeroNode2 node = root;
        while (node != null) {
            //循环的找到 leftType == 1 的结点，第一个找到就是 8 结点
            // 后面随着遍历而变化,因为当 leftType==1 时，说明该结点是按照线索化
            // 处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //前序遍历线索化二叉树的方法
    public void preThreadList(HeroNode2 root) {
        //定义一个变量，存储当前遍历的结点，从 root 开始
        HeroNode2 node = root;
        while (node != null) {
            //当节点的leftType=0,说明有左孩子，则遍历
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            //打印最后一个左子节点
            System.out.println(node);
            //遍历完右孩子节点

            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //后序遍历线索化二叉树的方法
    public void postThreadList(HeroNode2 root) {
        //定义一个变量，存储当前遍历的结点，从 root 开始
        HeroNode2 node = root;
        while (node != null) {
            //循环的找到 leftType == 1 的结点，第一个找到就是 8 结点
            // 后面随着遍历而变化,因为当 leftType==1 时，说明该结点是按照线索化
            // 处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            if (node == root) {
                break;
            }
            node = root.getRight();

        }
    }

}

//先创建HeroNode 结点
class HeroNode2 {
    private int no;
    private String name;
    private HeroNode2 left;//默认 null
    private HeroNode2 right;//默认 null
    //1. 如果 leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果 rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点
    private int leftType;
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }
}