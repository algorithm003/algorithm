class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
		/****************method1**************/
         vector<vector<int>> res;
         vector<int> cur;
        
         sort(nums.begin(), nums.end());
         solve(nums, 0, cur, res);
         return res;
     }
    
     void solve(vector<int> &s, int start, vector<int> cur, vector<vector<int>> &res){
         res.push_back(cur);
         for (int i = start; i < s.size(); i++) {
             cur.push_back(s[i]);
             solve(s, i + 1, cur, res);
             cur.pop_back();
         }
     }
       

		/****************method2****************/
        vector<vector<int>> res(1);
        
        sort(nums.begin(), nums.end());
        
        int n = nums.size();
        for(int i = 0; i < n; i++){
            int m = res.size();
            for(int j = 0; j < m; j++){
                res.push_back(res[j]);
                res.back().push_back(nums[i]);
            }
        }
        
        return res;
    }
};