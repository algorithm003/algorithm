//class Solution {
//public:
//    vector<vector<int>> threeSum(vector<int>& nums) {
//        if (nums.empty())
//            return {};
//        
//        sort(nums.begin(), nums.end());
//        if (nums.front() > 0 || nums.back() < 0)
//            return {};
//        
//        int n = nums.size();
//        vector<vector<int>> res;
//        for (int i = 0; i < n - 2; i++){
//            if (nums[i] > 0)
//                break;
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            
//            int p = i + 1, q = n - 1;
//            while (p < q){
//                if (nums[p] + nums[q] + nums[i] == 0){ 
//                    res.push_back({nums[i], nums[p], nums[q]});
//                    while(p < q && nums[p] == nums[p + 1])
//                        p++;
//                    while(q > p && nums[q] == nums[q - 1])
//                        q--;
//                    p++, q--;
//                }else if (nums[p] + nums[q] + nums[i] > 0) 
//                    q--;
//                else
//                    p++;
//            }
//        }
//        
//        return res;
//    }
//};