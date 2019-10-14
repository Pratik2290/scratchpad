package com.test.code;

public class StringPalindrome {


    public static void main(String[] args) {

        String s = "abccba";
        System.out.println(isPalindrome(s, 0, s.length() - 1));

    }

    private static boolean isPalindrome(String s, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return true;
        }

        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return isPalindrome(s, startIndex + 1, endIndex - 1);
        }
        return false;
    }
}
