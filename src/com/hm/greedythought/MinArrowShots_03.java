package src.com.hm.greedythought;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心策略： 投飞镖刺破气球
 * https://blog.csdn.net/weixin_37763870/article/details/103916148?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control
 * 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 * 也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
 *
 */
public class MinArrowShots_03 {
    public static void main(String[] args) {
        int[][]intervals = {{10,16}, {2,8}, {1,6}, {7,12}};
//        int[][]intervals = {{1,3},{4,5},{1,2}};
//        int[][]intervals = {{5,6},{7,8},{9,10}};
        System.out.println(MinArrowShots_03.getMinArrowShots(intervals));
    }

    private static int getMinArrowShots(int[][] points){

        // 1 先判断
        if (points.length == 0 ){
            return 0;
        }

        // 2 排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]<o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1));
            }
        });

        int end = points[0][1];
        int cnt = 1;
        //3 循环
        for (int i = 1; i <points.length ; i++) {
            if(points[i][0] <= end){
                continue;
            }
            end = points[i][1];
            cnt ++;
        }
        return cnt;
    }
}
