class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) { 
        map<long long, int> m;
        int j = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++){
            if(i - j > k)
                m.erase(nums[j++]);
            
            auto begin = m.lower_bound((long long)nums[i] - t);
            if (begin != m.end())
                if (abs(nums[i] - begin->first) <= t)
                    return true;
            m[nums[i]] = i;
        }
        return false;
    }
    
};