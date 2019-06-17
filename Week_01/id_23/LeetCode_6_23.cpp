class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        if (nums.size() < 3)
            return res;
        
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size()-2 && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            for (int j = i+1; j < nums.size()-1; ++j) {
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                if (nums[i] + nums[j] + nums[j+1] > 0)
                    break;
                
                int k = findNum(nums, j+1, -nums[i]-nums[j]);
                if (k != -1)
                    res.push_back(vector<int>{nums[i], nums[j], nums[k]});
            }
        }
        
        return res;
    }
    
    int findNum(const vector<int> &nums, int begin, int target) {
        int count = nums.size();
        
        if (nums[begin] > target || 
            nums[count-1] < target)
            return -1;
        
        int start = begin;
        int end = count-1;
        int mid = start + (end - start) / 2;
        while (mid > start && mid < end) {
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] < target) {
                start = mid + 1;
                mid = start + (end - start) / 2;
                continue;
            }
            
            end = mid - 1;
            mid = start + (end - start) / 2;
        }
        
        return (nums[start] == target) ? start : 
               ((nums[end] == target) ? end : -1);
    }
};
