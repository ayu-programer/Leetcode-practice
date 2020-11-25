package src.com.hm.greedythought;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.cnblogs.com/yjxyy/p/11105035.html
 * ̰��˼�룺 ������ߺ�����������
 * Input:   [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:  [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * һ��ѧ������������ (h, k) ������h ��ʾ��ߣ�k ��ʾ����ǰ����� k ��ѧ������߱����߻��ߺ���һ���ߡ�
 * Ϊ��ʹ���������Ӱ������Ĳ�������߽ϸߵ�ѧ��Ӧ���������������������߽�С��ѧ��ԭ����ȷ����ĵ� k ��λ�ÿ��ܻ��ɵ� k+1 ��λ�á�
 * ��� h ���򡢸��� k ֵ����Ȼ��ĳ��ѧ��������еĵ� k ��λ���С�
 */
public class ResetQueue_04 {
    public static void main(String[] args) {
        int[][]input  = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][]Output = {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        int[][] tep= ResetQueue_04.reconstructQueue(input);
        for (int[] t: tep) {
            System.out.println(t);
        }
//        System.out.println();
    }


    public static int[][]reconstructQueue(int[][]people){
       //1 ���ж�people�Ƿ�Ϊ��
        if (people == null || people.length ==0){
            return  null;
        }

        //2 �Զ�ά����������򣬰���h���򣬰���k��������
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //todo ����h�������򣬰���k��������
                return ((o1[0]==o2[0]) ? o1[1]-o2[1]:o2[0]-o1[0]);
            }
        });

        //�½�һ��list
        //3 ��Ԫ�ؼ��뵽�´�����list��
        //todo �����ǽ����ݲ��뵽���еĵ�k��λ��
        List<int[]> resList = new ArrayList<int[]>();
        for (int[] q: people) {
//            resList.add(q);
            resList.add(q[1],q);
        }

        //4 ��listת������
        return resList.toArray(people);
    }
}
