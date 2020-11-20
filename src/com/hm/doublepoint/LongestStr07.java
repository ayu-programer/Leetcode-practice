/**
* <p>Title: IsHasCycle06.java</p>  
* <p>Description: </p>   
* @author hanmeng
* @date 2020-11-16  
* @version 1.0 
*/
package com.atguigu.algorithm.leetcode.arr;

import java.util.Arrays;
import java.util.List;




/**删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 * @author hm 双指针问题
 *  Input:  s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *	Output: "apple"
 */
public class LongestStr07 {
public static void main(String[] args) {
	LongestStr07 h = new LongestStr07();
	String s = "abpcplea";
	String [] arr = {"apple","monkey","plea","ale"};
	List<String> list = Arrays.asList(arr);
	System.out.println(h.findLongestWord(s, list));
	
}

public String findLongestWord(String s, List<String> d) {
	 //1 指定最长字符
	 String longestWord = "";
	 
	 //2 遍历
	 for (String target : d) {
		//2.1 求最长字符串的长度
		 int longestLength = longestWord.length();
		 int targetLength = target.length();
		//2.2 如果目标字符串的长度小于最长字符串，或者两者都为空时
		 if(longestLength > targetLength || (longestLength == targetLength && longestWord.compareTo(target)<0)){
			 continue;
		 }
		 
		 //判断目标字符串是否包含再给定字符中
		 if(isSubStr(s,target)){
			 longestWord = target;
		 }
	}
	 return longestWord;
}

	/**
	 * @param s
	 * @param target
	 * @return
	 */
	private boolean isSubStr(String s, String target) {
		int i = 0; int j = 0;
		while (i< s.length() && j<target.length()) {
			if(s.charAt(i)== target.charAt(j)){
				j++;
			}
			i++;
		}
		return j==target.length();
	}
}


