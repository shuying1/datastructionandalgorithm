package com.iflytek.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //(30+4)×5-6 => 30 4 + 5 × 6 - => 164
        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
        // 测试
        // 说明为了方便，逆波兰表达式的数字和符号使用空格隔开
         String suffixExpression = "30 4 + 5 * 6 -";
        //String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        // 思路
        // 1. 先将 "30 4 + 5 × 6 - " => 放到ArrayList 中
        // 2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        List<String> list=getListString(suffixExpression);
        System.out.println("rpnList=" + list);
        System.out.println("逆波兰式计算结果为"+calculate(list));
    }
    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getListString(String suffixExpression){
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list=new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    //完成对逆波兰表达式的运算
    /*
     * 1)从左至右扫描，将 30 和 4 压入堆栈；
     * 2)遇到+运算符，因此弹出 4 和 30（4 为栈顶元素，30 为次顶元素），计算出 30+4 的值，得 34，再将 34 入栈；
     * 3)将 5 入栈；
     * 4)接下来是×运算符，因此弹出 5 和 7，计算出 34×5=170，将 170 入栈；
     * 5)将 6 入栈；
     * 6)最后是-运算符，计算出 170-6 的值，即 164，由此得出最终结果
     */

    public static int calculate(List<String> ls){
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack=new Stack<>();
        // 遍历 ls
        for (String s : ls) {
            // 这里使用正则表达式来取出数
            if (s.matches("\\d+")){// 匹配的是多位数
                // 入栈
                stack.push(s);
            }else{
                // pop 出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res=0;
                if (s.equals("+")){
                    res = num1 + num2;
                }else if (s.equals("-")){
                    res = num1 - num2;
                }else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把 res 入栈
                stack.push(String.valueOf(res));
            }
        }
        //最后留在 stack 中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
