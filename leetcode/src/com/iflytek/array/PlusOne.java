package com.iflytek.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yings
 * @create 2022-06-10 20:34
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,9,9};
        int[] nums = plusOne(digits);
        System.out.println(Arrays.toString(nums));


    }

    //自己写的
    public static int[] plusOne(int[] digits) {
        //将数组里的数字转为字符串
        String strNum = "";
        for (int digit : digits) {
            strNum += digit;
        }
        //将字符串转为整数并加1
        int num = Integer.parseInt(strNum) + 1;
        //定义一个集合存放num，但结果是反的
        List<Integer> numList = new ArrayList<>();
        while (num != 0) {
            int a = num % 10;
            numList.add(a);
            num = num / 10;
        }

        int[] numArray = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            //顺序颠倒
            numArray[i] = numList.get(numList.size() - 1 - i);
        }
        return numArray;
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        //如果digits 的所有元素都是 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public static int[] plusOne3(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                //如果数组当前元素不等于9，直接加1
                //然后直接返回
                digits[i]++;
                return digits;
            }else {
                digits[i]=0;
            }
        }
        //除非数组中的元素都是9，否则不会走到这一步，
        //如果数组的元素都是9，我们只需要把数组的长度
        //增加1，并且把数组的第一个元素置为1即可
        int temp[] = new int[length + 1];
        temp[0] = 1;
        return temp;
    }
}
