package src.com.hm.greedythought;

import java.util.Arrays;

/**
 * 题目描述：每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 * Input: grid[1,3], size[1,2,4]
   Output: 2
 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class DistributeBiscuits_01 {
    public static void main(String[] args) {
        int[]grid = {1,3};
        int[]biscuits = {1,2,4};
        System.out.println(DistributeBiscuits_01.findChildDbisNum(grid,biscuits));
    }

    private static int findChildDbisNum(int[]grid,int[]biscuits){
        Arrays.sort(grid);
        Arrays.sort(biscuits);
        int gridStart = 0;
        int biscuitsStart = 0;
        while (gridStart<grid.length && biscuitsStart < biscuits.length){
            if(grid[gridStart] <= biscuits[biscuitsStart]){
                gridStart++;
            }
            biscuitsStart++;
        }
        return gridStart;
    }
}
