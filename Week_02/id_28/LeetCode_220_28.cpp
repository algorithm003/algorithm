class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        if (!k) return false;
        set<long> s;
        for (int i = 0; i < nums.size(); i++) {
            if (s.size() > k) s.erase(s.find(nums[i - k - 1]));
            auto it = s.lower_bound(nums[i]);
            if (it != s.end() && (*it) - nums[i] <= t) return true;
            s.insert(nums[i]);
            auto l = s.find(nums[i]);
            if ((l-- != s.begin()) && (nums[i] - (*l) <= t)) return true;
        }
        return false;
    }
};
