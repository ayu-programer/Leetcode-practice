package src.com.hm.greedythought;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.cnblogs.com/yjxyy/p/11105035.html
 * 贪心思想： 根据身高和序号重组队列
 * Input:   [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:  [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
 * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
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
       //1 先判断people是否为空
        if (people == null || people.length ==0){
            return  null;
        }

        //2 对二维数组进行排序，按照h降序，按照k升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //todo 按照h降序排序，按照k升序排列
                return ((o1[0]==o2[0]) ? o1[1]-o2[1]:o2[0]-o1[0]);
            }
        });

        //新建一个list
        //3 将元素加入到新创建的list中
        //todo 这里是将数据插入到队列的第k个位置
        List<int[]> resList = new ArrayList<int[]>();
        for (int[] q: people) {
//            resList.add(q);
            resList.add(q[1],q);
        }

        //4 将list转成数组
        return resList.toArray(people);
    }
}
