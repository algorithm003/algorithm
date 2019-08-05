package Week_04.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/11 10:59
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/11 10:59
 * 修改备注：
 */
public class LeetCode_714_037 {
    /**
     * 买卖股票的最佳时机含手续费
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if( prices.length < 2 ){return 0;}
        int n = prices.length ,result = 0,min = prices[0];
        for(int i=0;i<n;i++){
            if(prices[i] < min){
                //找到比当前min更低的价格，可以直接使用
                min = prices[i];
            }else if(prices[i] > (min + fee)){
                result += prices[i] - fee - min;
                min= prices[i] - fee;
            }
        }
        return result;
    }
}
