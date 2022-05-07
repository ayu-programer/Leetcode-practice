package src.com.hm.sort;

/**
 * 题目：给定一个包含红色、白色和蓝色，一共n  个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。此题中，我们使用整数 、 和  分别表示红色、白色和蓝色。要求：仅使用常数空间的一趟扫描算法。
 * 荷兰国旗问题：给定一个数组 nums 和一个数 mid ，把小于 mid 的数放到数组的左边，
 * 等于 mid 的数放在数组的中间，大于 mid 的数放在数组的右边。
 * 要求：时间复杂度 O(N)，空间复杂度O(1)。
 * 问题：为什么情况2  不执行 cur++ 操作？因为我们无法判断从最右边交换过来的数据就一定不是蓝色，所以在下一轮判断的时候继续判断当前位置
 * http://ll028.cn/62BjXS
 * //红白蓝 ===》0，1，2
 */

public class DutchFlagProblem {
    public static void main(String[] args) {
        DutchFlagProblem d = new DutchFlagProblem();
        int[] nums = {1,2,0,2,1,1,0,1,2,1,0,1,2};
        d.sortColors(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+",");
        }
    }

    public void sortColors(int[] nums) {
        final int MEDIUM = 1;

        int n = nums.length;
        // 初始化指针的位置, 一开始认为左边没有红色, 右边没有蓝色
        int r0 = 0, last = n - 1, cur = 0;

        while (cur <= last) {
            if (nums[cur] < MEDIUM) { // 当前值是红色
                swap(nums, cur++, r0++);
            } else if (nums[cur] > MEDIUM) { // 当前值是蓝色
                swap(nums, cur, last--);
            } else { // 当前值是白色
                cur++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
