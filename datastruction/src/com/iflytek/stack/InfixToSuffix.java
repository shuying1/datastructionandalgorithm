package com.iflytek.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Operation {
    private static int ADD_SUB = 1;
    private static int MUL_DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
            case "-":
                res = ADD_SUB;
                break;
            case "*":
            case "/":
                res=MUL_DIV;
                break;

            default:
                System.out.println("不存在该运算符");
                break;
        }
        return res;
    }
}
public class InfixToSuffix {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        // 说明
        // 1. 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
        //2. 因为直接对 str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的 List
        // 即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        // 3. 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        // 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的 List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpressionList = parseSuffixExpresionList(infixExpressionList);
        System.out.println("后缀表达式对应的 List" + suffixExpressionList); //ArrayList [1,2,3,+,4,*,+,5,–]
        System.out.printf("expression=%d", calculate(suffixExpressionList)); // ?
    }
    //方法：将 中缀表达式转成对应的 List
    // s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s){
        //定义一个 List,存放中缀表达式 对应的内容
        List<String> ls=new ArrayList<>();
//        String str="";// 对多位数的拼接

        char c='\0';// 每遍历到一个字符，就放入到 c
        for (int i = 0; i < s.length(); i++) {
            //如果 c 是一个非数字，我需要加入到 ls
            if ((c=s.charAt(i))<48||(c=s.charAt(i))<=57){
                ls.add(c+"");//转为字符串
            }else{//如果是一个数，需要考虑多位数
                String str = ""; // 对多位数的拼接//先将 str 置成"" '0'[48]->'9'[57]
                while ((c=s.charAt(i))>=48&&(c=s.charAt(i))<=57&&i<s.length()){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }
        return ls;
    }
    //即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
    // 方法：将得到的中缀表达式对应的 List => 后缀表达式对应的 List
    public static List<String> parseSuffixExpresionList(List<String> ls) {
        //定义两个栈
        Stack<String> optStack = new Stack<String>(); // 符号栈
        //说明：因为 numStack 这个栈，在整个转换过程中，没有 pop 操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> numStack
        // Stack<String> numStack = new Stack<String>(); // 储存中间结果的栈 numStack
        List<String> numStack = new ArrayList<>();

        //遍历 ls
        for (String item : ls) {
            if (item.matches("\\d+")) {
                numStack.add(item);
            } else if (item.equals("(")) {
                optStack.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出 optStack 栈顶的运算符，并压入 numStack，直到遇到左括号为止，此时将这一对括号丢弃
                while (!optStack.peek().equals("(")) {
                    numStack.add(optStack.pop());
                }
                optStack.pop();//!!! 将 ( 弹出 s1 栈， 消除小括号
            } else {
                //当 item的优先级小于等于 optStack 栈顶运算符, 将 optStack 栈顶的运算符弹出并加入到 numStack 中，再次转到(4.1)与 optStack 中新的栈顶运算符相比较

                //问题：我们缺少一个比较优先级高低的方法
                while (optStack.size()!=0&&Operation.getValue(optStack.peek())>=Operation.getValue(item)){
                    numStack.add(optStack.pop());
                }
                //还需要将 item压入栈
                optStack.push(item);
            }
        }
        //将 optStack 中剩余的运算符依次弹出并加入 numStack
        while (optStack.size()!=0){
            numStack.add(optStack.pop());
        }
        return numStack;//注意因为是存放到 List, 因此按顺序输出就是对应的后缀表达式对应的 List
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


