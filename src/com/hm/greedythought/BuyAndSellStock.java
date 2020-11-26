package src.com.hm.greedythought;

/**
 * 贪心思想：求股票中得最大收益
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 *只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
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
