package src.com.hm.greedythought;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心策略： 计算让一组区间不重叠所需要移除的区间个数。
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 *     思路：先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 *          在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *          按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 *
 */
public class RemoveDupleteArr_02 {
    public static void main(String[] args) {
//        int[][]intervals = {{1,4},{2,4},{3,4}};
//        int[][]intervals = {{1,3},{4,5},{1,2}};
        int[][]intervals = {{5,6},{7,8},{9,10}};
        System.out.println(RemoveDupleteArr_02.getReoveDupArr(intervals));
    }

    private static int getReoveDupArr(int[][] intervals){
        if (intervals.length == 0) {
            return 0;
        }

        //1 对数组进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
            }
        });

        int cnt = 1;
        //2 取第一个数组区间的下边界
        int end = intervals[0][1];
        //3 循环判断其余数组区间的上边界是否小于第一个数组的下边界  TODO 如果小于则说明该区间和第一个区间重叠，反之大于的话不重叠
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            //3.1 大于第一个数组的下边界，当前区间与第一个区间不重叠。
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
