class Solution {
public:
    int climbStairs(int n) {
		/**************method1*****************/
         vector<int> dp(n+1, 0);
         dp[0] = 1;
         dp[1] = 1;
         for(int i = 2; i <= n; i++)
             dp[i] = dp[i - 1] + dp[i - 2];
        
         return dp[n];
     }
        

	/**************method2*****************/
        long a = 1, b = 1;
        while (n--) {
            b += a;
            a = b - a;
        }
        
        return a;
    }
};