package src.com.hm.greedythought;

import java.util.Arrays;

/**
 * ��Ŀ������ÿ�����Ӷ���һ������� grid��ÿ�����ɶ���һ����С size��ֻ�б��ɵĴ�С���ڵ���һ�����ӵ�����ȣ��ú��ӲŻ������㡣��������Ի������ĺ���������
 * Input: grid[1,3], size[1,2,4]
   Output: 2
 ��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ���ÿ������ i ������һ��θ��ֵ gi ���������ú���������θ�ڵı��ɵ���С�ߴ磻
 ����ÿ����� j ������һ���ߴ� sj ����� sj >= gi �����ǿ��Խ�������� j ��������� i ��������ӻ�õ����㡣���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��
 */
public class DistributeBiscuits_01 {
    public static void main(String[] args) {
        int[]grid = {1,3};
        int[]biscuits = {1,2,4};
        System.out.println(DistributeBiscuits_01.findChildDbisNum(grid,biscuits));
    }

    private static int findChildDbisNum(int[]g,int[]s){
        //1 �ȶ����������������
        Arrays.sort(g);
        Arrays.sort(s);
        //2 �����������ʼ��
        int gridStart = 0;
        int biscuitsStart = 0;
        while (gridStart<g.length && biscuitsStart < s.length){
            //3 ������ɵ�size���ڻ��ߵ��ں��ӵ������grid��������һ
            if(g[gridStart] <= s[biscuitsStart]){
                gridStart++;
            }
            biscuitsStart++;
        }
        return gridStart;
    }
}
