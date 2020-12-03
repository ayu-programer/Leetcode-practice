package src.com.hm.greedythought;

/**
 * 贪婪思想：最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 解题思路：本题关键要再每一次遍历中对start和sumNum的值进行比较
 */
public class MaximumSubarray_09 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(MaximumSubarray_09.maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        //1 先判断数组是否为空
        if (nums == null || nums.length == 0){
            return 0;
        }

        int start = nums[0];
        int sumNum = start;
        //2 遍历数组
        for (int i = 1; i <nums.length ; i++) {
          //2.1 判断起始值start是否大于0
          if(start>0){
              start += nums[i];
          }else{//如果不大于0，就将当前坐标值设为起始值
              start = nums[i];
          }

          //3 求最大值
          sumNum = Math.max(sumNum,start);
        }
        return sumNum;
    }


}
