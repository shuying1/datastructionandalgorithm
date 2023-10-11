package com.iflytek.string;

/**
 * @author yings
 * @create 2022-07-03 10:29
 */
public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        System.out.println(s.toLowerCase());
        boolean palindromeHelper = isPalindromeHelper(s, 0, s.length() - 1);
        System.out.println(palindromeHelper);
    }

    public static boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();//匹配除数字字母以外的字符
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);

    }

    public static boolean isPalindrome2(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeHelper(String s, int left, int right) {
        if (left >= right)
            return true;
        while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
            left++;
        while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
            right--;
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)) && isPalindromeHelper(s, ++left, --right);

    }
}
