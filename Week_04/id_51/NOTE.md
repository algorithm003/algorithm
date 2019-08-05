# 学习笔记

week_04

####Finished almost all the buy and sell stock problems this week.
#####When we define the state, we need consider three dimensions: maxProfit[numDays][2][numTransactions]:

#####state definition  
1. maxProfit[i][0][k] means on day i is holding position, and already finished k transactions
2. maxProfit[i][1][k] means on day i is flat position, and already finished k transactions
3. fee is transaction fee

#####state transfer function
1. function
    - mp[i][0][k] = max(mp[i - 1][1][k] + prices[i], mp[i - 1][0][k]);
    - mp[i][1][k] = max(mp[i - 1][0][k - 1] - prices[i] - fee, mp[i - 1][1][k]);
2. explanation
    - When buy a stock means enter into a transaction so transaction used should add 1 and need minus transaction fee: 
      mp[i][1][k] = max(mp[i - 1][0][k - 1] - prices[i] - fee, mp[i - 1][1][k])

    - When sell stock, no need to count transaction again since buy and sell count for 1 transaction and already count 1 when buy:
      mp[i][0][k] = max(mp[i - 1][1][k] + prices[i], mp[i - 1][0][k]);

#####initial state 
mp[0][0][k] = 0; <br/>
mp[0][1][k] = -prices[0] - fee;
k = 0..numTrans
 
#####complexity
   - time complexity: O(N*K) 
   - space complexity : O(N*K) 
   - N is numDays and K is numTransactions 