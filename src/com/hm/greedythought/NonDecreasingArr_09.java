package src.com.hm.greedythought;


/**
 * ��Ŀ�������ж�һ�������Ƿ���ֻ�޸�һ�����ͳ�Ϊ�ǵݼ����顣
 * �ڳ��� nums[i] < nums[i - 1] ʱ����Ҫ���ǵ���Ӧ���޸�������ĸ�����ʹ�ñ����޸���ʹ i ֮ǰ�������Ϊ�ǵݼ����飬���� ��Ӱ������Ĳ��� ��
 * ���ȿ����� nums[i - 1] = nums[i]����Ϊ����޸� nums[i] = nums[i - 1] �Ļ�����ô nums[i] ���������
 * ���п��ܱ� nums[i + 1] �󣬴Ӷ�Ӱ���˺���������
 * ����һ���Ƚ��ر��������� nums[i] < nums[i - 2]���޸� nums[i - 1] = nums[i] ����ʹ�����Ϊ�ǵݼ����飬ֻ���޸� nums[i] = nums[i - 1]��
 * ע�����ע��Ҫ����nums[i]<nums[i-2] �������
 */
public class NonDecreasingArr_09 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(NonDecreasingArr_09.checkPossibility(nums));
    }

    private static boolean  checkPossibility(int[] nums) {
        int cnt =0;
        for (int i = 1; i <nums.length && cnt<2 ; i++) {
            if(nums[i] >= nums[i-1]){
                continue;
            }

            cnt++;
            if (i-2 >= 0 && nums[i-2]>nums[i]){
                nums[i] = nums[i-1];
            }else{
                nums[i-1]= nums[i];
            }
        }

        return cnt<=1;
    }


}
