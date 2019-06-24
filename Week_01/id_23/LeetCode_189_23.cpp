class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int size = nums.size();
        k = (k < size) ? k : k % size;
        if (0 == k)
            return;
        
        rotate(nums, 0, size-1-k);
        rotate(nums, size-k, size-1);
        rotate(nums, 0, size-1);
    }
    
    void rotate(vector<int>& nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
};
