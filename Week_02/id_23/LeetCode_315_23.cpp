class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        vector<int> res(nums.size(), 0);
        vector<int> sorted(nums.size(), 0);
        iota(sorted.begin(), sorted.end(), 0);
        mergeSort(nums, 0, nums.size()-1, sorted, res);
        return res;
    }
    
    void mergeSort(const vector<int> &nums, int beg, int end, vector<int> &sorted, vector<int> &res) {
        if (end <= beg)
            return;
        
        int prev = beg; int mid = beg + (end-beg)/2; int post = mid+1;
        mergeSort(nums, prev, mid, sorted, res);
        mergeSort(nums, post, end, sorted, res);
        
        int count = 0; vector<int> mergeRes;
        while (prev <= mid || post <= end) {
            if (prev > mid || (post <= end && nums[sorted[prev]] > nums[sorted[post]])) {
                mergeRes.push_back(sorted[post++]);
                ++ count;
            } else {
                mergeRes.push_back(sorted[prev]);
                res[sorted[prev++]] += count;
            }
        }
        std::copy(mergeRes.begin(), mergeRes.end(), sorted.begin()+beg);
    }
};
