package com.iflytek.string;



/**
 * @author yings
 * @create 2022-08-31 9:40
 */
public class CountAndSay {
    public static void main(String[] args) {
        String res = countAndSay2(5);
        System.out.println("res = " + res);
    }

    /**
     * Input: n = 4
     * Output: "1211"
     * Explanation:
     * countAndSay(1) = "1"
     * countAndSay(2) = say "1" = one 1 = "11"
     * countAndSay(3) = say "11" = two 1's = "21"
     * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        // 递归出口
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        String res = "";
        char item = str.charAt(0);
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            int j = i;
            while (j + 1 < str.length() && str.charAt(j + 1) == str.charAt(j)) {
                j++;
            }
            res += "" + (j - i + 1) + str.charAt(i);
            i = j;
        }
        return res;
    }



    public static String countAndSay2(int n) {
        String res="1";
        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder=new StringBuilder();
            int index=0;

            while (index<res.length()){
                int count=1;
                while (index<res.length()-1&&res.charAt(index)==res.charAt(index+1)){
                    index++;
                    count++;
                }
                stringBuilder.append(count).append(res.charAt(index));
                index++;

            }
            res=stringBuilder.toString();
        }
        return res;

    }

}
