class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        } 
        int nDays = prices.length;
        int[] flat = new int[nDays];
        int[] hold = new int[nDays];
        flat[0] = 0;
        hold[0] = -prices[0] - fee;
        
        for (int i = 1; i< nDays; i++) {
            flat[i] = Math.max(flat[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], flat[i - 1] - prices[i] - fee);
        }
        
        return Math.max(flat[nDays - 1], hold[nDays - 1]);
    }
}
