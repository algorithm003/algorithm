class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int flat = 0;
        int hold = -prices[0]; 
        int sold = 0;    
        for (int i = 1; i < prices.length; i++) {
            int tmpHold = Math.max(flat - prices[i], hold);
            flat = Math.max(flat, sold);
            sold = hold + prices[i];
            hold = tmpHold;
        }
        
        return Math.max(flat, sold);
    }
}
