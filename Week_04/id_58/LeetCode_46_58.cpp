class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
		/*******************method1***********************/
        vector<vector<int>> res;
        solve(nums, res, 0);
        return res;
    }
    
    void solve(vector<int> nums, vector<vector<int>> &res, int start){
        if (start == nums.size()) {
            res.push_back(nums);
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums[i], nums[start]);
            solve(nums, res, start + 1);
            swap(nums[i], nums[start]);
        }
    }
 
        
        /*******************method2***********************/
         vector<vector<int>> res;
         vector<int> cur;
         vector<int> visited(nums.size(), 0);
        
         solve(nums, 0, cur, res, visited);
         return res;
     }
    
     void solve(vector<int> nums, int cnt, vector<int> cur, vector<vector<int>> &res,
               vector<int> visited){
         if (cur.size() == nums.size()) {//if(cnt == nums.size())
             res.push_back(cur);
             return;
         }

         for (int i = 0; i < nums.size(); i++) {
             if (visited[i])
                 continue;
            
             visited[i] = 1;
             cur.push_back(nums[i]);
             solve(nums, cnt + 1, cur, res, visited);
            
             cur.pop_back();
             visited[i] = 0;
         }
     }
};