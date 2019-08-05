class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int nDays = prices.length;
        if (k >= nDays/2) {
            return greedy(prices);
        }
        
        int[][][] mp = new int[nDays][2][k + 1];
        for (int kk = 0; kk < k + 1; kk++) {
            mp[0][0][kk] = 0;
            mp[0][1][kk] = -prices[0];    
        }
        int maxProfit = 0;
        for (int kk = 1; kk < k + 1; kk++) {            
            for (int i = 1; i < nDays; i++) {
                mp[i][0][kk] = Math.max(mp[i - 1][1][kk] + prices[i], mp[i - 1][0][kk]);
                mp[i][1][kk] = Math.max(mp[i - 1][0][kk - 1] - prices[i], mp[i - 1][1][kk]);
            }
            if (mp[nDays-1][0][kk] > maxProfit) {
                maxProfit = mp[nDays-1][0][kk];
            }
        }
        
        return maxProfit; 
    }
    
    private int greedy(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i< prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
