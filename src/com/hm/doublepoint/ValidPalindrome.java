package com.hm.doublepoint;

/**
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 * 所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。

 使用双指针可以很容易判断一个字符串是否是回文字符串：令一个指针从左到右遍历，一个指针从右到左遍历，这两个指针同时移动一个位置，
 每次都判断两个指针指向的字符是否相同，如果都相同，字符串才是具有左右对称性质的回文字符串。
 https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%8F%8C%E6%8C%87%E9%92%88.md
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "aeghhhhsga";
        System.out.println(v.judgeValidPalidome(s));
    }

    private boolean judgeValidPalidome(String s){
        for (int i = 0,j= s.length()-1;i<j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)){
                return isPalidome(s,i+1,j)|| isPalidome(s,i,j-1);
            }
        }
        return true;
    }

    private boolean isPalidome(String s, int i, int j) {
       while (i<=j){
           if (s.charAt(i++) != s.charAt(j--)){
               return false;
           }
       }
       return true;
    }
}
