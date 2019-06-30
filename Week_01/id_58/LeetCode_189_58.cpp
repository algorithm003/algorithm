//class Solution {
//public:
//    void rotate(vector<int>& nums, int k) {
//    //     vector<int> t = nums;
//    //     for (int i = 0; i < nums.size(); i++){
//    //         nums[(i + k) % nums.size()] = t[i];
//    //     }
//    // }
//        
//        if (nums.empty() || (k %= nums.size()) == 0) 
//			return;
//
//        int n = nums.size();
//        reverse(nums.begin(), nums.begin() + n - k);
//        reverse(nums.begin() + n - k, nums.end());
//        reverse(nums.begin(), nums.end());
//    }
//};
