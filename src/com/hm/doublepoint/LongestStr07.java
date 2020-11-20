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




/**ɾ�� s �е�һЩ�ַ���ʹ���������ַ����б� d �е�һ���ַ������ҳ��ܹ��ɵ���ַ���������ж����ͬ���ȵĽ���������ֵ������С�ַ�����
 * @author hm ˫ָ������
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
	 //1 ָ����ַ�
	 String longestWord = "";
	 
	 //2 ����
	 for (String target : d) {
		//2.1 ����ַ����ĳ���
		 int longestLength = longestWord.length();
		 int targetLength = target.length();
		//2.2 ���Ŀ���ַ����ĳ���С����ַ������������߶�Ϊ��ʱ
		 if(longestLength > targetLength || (longestLength == targetLength && longestWord.compareTo(target)<0)){
			 continue;
		 }
		 
		 //�ж�Ŀ���ַ����Ƿ�����ٸ����ַ���
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


