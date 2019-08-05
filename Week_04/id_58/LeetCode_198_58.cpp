class Solution {
public:
    int rob(vector<int>& nums) {
		/******************method1*************************/
        int n = nums.size();
        if(n <= 1)
            return nums.empty() ? 0 : nums[0];
        
        vector<int> dp{nums[0], max(nums[0], nums[1])};
        for(int i = 2; i < n; i++){
            dp.push_back(max(nums[i] + dp[i - 2], dp[i - 1]));
        }
        
        return dp.back();
    }
        
	/******************method2*************************/
         int old = 0, even = 0;
         int n = nums.size();
         for(int i = 0; i < n; i++){
             if(i & 1){
                 old = max(old + nums[i], even);
             }else{
                 even = max(even + nums[i], old);
             }
         }
        
         return max(even, old);
     }
};