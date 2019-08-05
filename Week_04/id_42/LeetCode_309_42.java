public class LeetCode_309_42 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] dp = new int[len + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            dp[i + 1] = Math.max(dp[i], prices[i] - min);
        }
        return dp[len - 1];
    }


    @Test
    public void test() {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
