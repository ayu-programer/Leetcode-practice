package src.com.hm.greedythought;


/**
 * 贪心思想：求子序列
 * s = "abc", t = "ahbgdc"    Return true.
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 本题关键：通过index来确定顺序
 */
public class IsSubsequence_08 {
    public static void main(String[] args) {
        String s = "chg", t = "ahbgdc";
        System.out.println(IsSubsequence_08.isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null){
            return false;
        }
        int index = -1;
        for (char c : s.toCharArray()) {

            index = t.indexOf(c,index+1);
            if (index == -1) {
                return false;
            }
        }
        return true;

//        if(s==null||t==null)
//            return false;
//        int indexs=0;
//        int indext=0;
//        while(indexs<s.length()&&indext<t.length()){
//            if(s.charAt(indexs)==t.charAt(indext)){
//                indexs++;
//            }
//            indext++;
//        }
//        return indexs==s.length();
    }

}
