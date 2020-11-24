package src.com.hm.greedythought;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ̰�Ĳ��ԣ� Ͷ���ڴ�������
 * https://blog.csdn.net/weixin_37763870/article/details/103916148?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control
 * ��Ŀ������������һ��ˮƽ�����ϰڷţ������ص������ڴ�ֱͶ�������ᣬʹ��·���ϵ����򶼱����ơ������С��Ͷ���ڴ���ʹ�������򶼱����ơ�
 * Ҳ�Ǽ��㲻�ص������������������ Non-overlapping Intervals ���������ڣ�[1, 2] �� [2, 3] �ڱ����������ص����䡣
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

        // 1 ���ж�
        if (points.length == 0 ){
            return 0;
        }

        // 2 ����
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]<o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1));
            }
        });

        int end = points[0][1];
        int cnt = 1;
        //3 ѭ��
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
