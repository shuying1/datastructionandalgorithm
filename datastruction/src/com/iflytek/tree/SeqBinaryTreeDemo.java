package com.iflytek.tree;


public class SeqBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        SeqBinaryTree seqBinaryTree = new SeqBinaryTree(arr);
        // seqBinaryTree.preOrder();//1,2,4,5,3,6,7
        seqBinaryTree.infixOrder();
        //seqBinaryTree.postOrder();

    }
}

class SeqBinaryTree {
    private int[] arr;

    public SeqBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载 preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    //重载 infixOrder
    public void infixOrder() {
        this.infixOrder(0);
    }

    //重载 postOrder
    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * @param index 数组的下标
     */
    public void infixOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    /**
     * @param index 数组的下标
     */
    public void postOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            postOrder(2 * index + 1);
        }
        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            postOrder(index * 2 + 2);
        }
        //输出当前这个元素
        System.out.println(arr[index]);
    }
}