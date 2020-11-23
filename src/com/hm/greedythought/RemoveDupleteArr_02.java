package src.com.hm.greedythought;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ̰�Ĳ��ԣ� ������һ�����䲻�ص�����Ҫ�Ƴ������������
 * ��Ŀ������������һ�����䲻�ص�����Ҫ�Ƴ������������
 *     ˼·���ȼ����������ɵĲ��ص����������Ȼ���������ܸ�����ȥ���ص�����ĸ�����
 *          ��ÿ��ѡ���У�����Ľ�β��Ϊ��Ҫ��ѡ��������βԽС���������������Ŀռ�Խ����ô�����ܹ�ѡ����������Ҳ��Խ��
 *          ������Ľ�β��������ÿ��ѡ���β��С�����Һ�ǰһ�����䲻�ص������䡣
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

        //1 �������������
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
            }
        });

        int cnt = 1;
        //2 ȡ��һ������������±߽�
        int end = intervals[0][1];
        //3 ѭ���ж���������������ϱ߽��Ƿ�С�ڵ�һ��������±߽�  TODO ���С����˵��������͵�һ�������ص�����֮���ڵĻ����ص�
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            //3.1 ���ڵ�һ��������±߽磬��ǰ�������һ�����䲻�ص���
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
