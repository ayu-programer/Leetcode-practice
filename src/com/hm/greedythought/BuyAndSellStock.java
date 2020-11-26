package src.com.hm.greedythought;

/**
 * ̰��˼�룺���Ʊ�е��������
 * ��Ŀ������һ�ι�Ʊ���װ��������������ֻ����һ�ν��ף���������档
 *ֻҪ��¼ǰ�����С�۸񣬽������С�۸���Ϊ����۸�Ȼ�󽫵�ǰ�ļ۸���Ϊ�۳��۸񣬲鿴��ǰ�����ǲ���������档
 *
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        int [] a = {7,1,5,3,6,4};
        System.out.println(BuyAndSellStock.tradeStock(a));
    }

    private static int tradeStock(int[]prices){
        if(prices == null ||prices.length ==0){
            return 0;
        }
        int maxValue = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(start<prices[i]){
                int b = prices[i]-start;
                if(b>maxValue){
                    maxValue = b;
                }
            }else{
                start = prices[i];
            }

        }
        return maxValue;
    }
}
