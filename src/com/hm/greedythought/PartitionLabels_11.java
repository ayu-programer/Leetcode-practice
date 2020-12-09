package src.com.hm.greedythought;

import java.util.ArrayList;
import java.util.List;

/**
 * （重点）
 * 贪心思想：分隔字符串使同种字符出现在一起
 * https://blog.csdn.net/qq_40320556/article/details/90346668?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
 * 第一个for循环，以26个英文字母的数组依次遍历整个S，记录S中每个字符出现的次数，存到对应的位置；
 * 之后我们要考虑怎么分割这个S了，看上面的例子第一个字符最后出现的位置是9 第二个字符出现的是6 定义一个指针index,
 * index不断增加 每遍历一个S中的字符就记录下这个字符最后出现的位置，定义一个lastIndex，记录前i个字符中，最后出现位置
 * 最大的值，这个最大值如果和i相同了， 说明前i个字符都不再后面出现 可以分割了
 * 这里由于firstIndex引入这是为了计算差值，此处等于-1；
 *
 *
 */
public class PartitionLabels_11 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(PartitionLabels_11.partitionLabels(s));
    }


    public static List<Integer> partitionLabels(String S) {
        //1 定义一个26个字母长度的数组
        int[] lastIndexOfChar = new int[26];
        //2 for循环将对应字符的最后一个下存到数组对应的位置
        for(int i=0; i < S.length(); i++){
            lastIndexOfChar[S.charAt(i) - 'a'] = i;
        }
        //3 定义一个lastindex   记录前i个字符中，最后出现位置 最大的值，这个最大值如果和i相同了 说明前i个字符都不再后面出现 可以分割了
        int LastIndex = 0;
        //4 引入firstIndex是为了计算差值
        int firstIndex = -1;
        List<Integer> str = new ArrayList<>();
        //for循环，这个最大值如果和i相同了， 说明前i个字符都不再后面出现 可以分割了
        for(int i=0; i < S.length(); i++){
            int index = lastIndexOfChar[S.charAt(i) - 'a'];
            LastIndex = Math.max(index, LastIndex);
            if(LastIndex == i){
                str.add(LastIndex - firstIndex);
                firstIndex = LastIndex;
            }
        }
        return str;
    }


}
