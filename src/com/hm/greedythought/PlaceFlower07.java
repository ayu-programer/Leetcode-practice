package src.com.hm.greedythought;

/**1,0,1,0,1,0,1
 *   Input: flowerbed = [1,0,0,0,1], n = 1
 *   Output: True
 *   ��Ŀ������flowerbed ������ 1 ��ʾ�Ѿ������˻��䡣����֮��������Ҫһ����λ�ļ��������Ƿ������� n �仨��
 *   ����Ĺؼ������Ҫ����Ϊ�������ȷ����ǰλ�ÿ��Է�1���Ͱѵ�ǰλ�õ�ֵ��Ϊ1.
 */
public class PlaceFlower07 {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1,0,0};

        System.out.println(PlaceFlower07.canPlaceFlowers(flowerbed,2));
    }

    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
//        if (flowerbed == null || flowerbed.length ==0){
//            return false;
//        }
//        int size = flowerbed.length;
//        int cnt = 0;
//        for (int i = 0; i <size&&cnt<n ; i++) {
//            if(size ==1){
//                if(flowerbed[0] == 0){
//                    cnt++;
//                }
//                break;
//            }
//            if (flowerbed[i] == 1){
//                continue;
//            }
//            int preIndexValue = i==0 ? 0 : flowerbed[i-1];
//            int endIndexValue = i == size-1 ?0:flowerbed[size+1];
//            if(preIndexValue ==0 && endIndexValue ==0){
//                cnt++;
//                flowerbed[i] =1;
//            }
//        }
//        return cnt>n;

        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //1 ���п�
        if (flowerbed == null || flowerbed.length ==0){
            return false;
        }

        //2 ������鳤��Ϊ1
        int count = 0;
        int size = flowerbed.length;
        if(size == 1){
            if(flowerbed[0] ==0){
                count ++;
            }
        }else{ //3 ������ݳ��Ȳ�Ϊ1
            //3.1�ж�index =0
            if((flowerbed[0] ==0 && flowerbed[1] != 1)){
                count ++;
                flowerbed[0] = 1;
            }
            //3.2 �ж�index=size -1��
            if((flowerbed[flowerbed.length-1] == 0) && flowerbed[flowerbed.length-2] !=1){
                count++;
                flowerbed[flowerbed.length-1] = 1;
            }
            //3.3�ж��м�Ԫ��
            for (int i = 1; i <size-2 ; i++) {
                if(flowerbed[i] == 1){
                    continue;
                }
                if(flowerbed[i-1] ==0 && flowerbed[i+1] ==0){
                    count++;
                    flowerbed[i]= 1;
                }
            }

        }
        return count>=n;
    }
}
