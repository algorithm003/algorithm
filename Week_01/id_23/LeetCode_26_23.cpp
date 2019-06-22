class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 1) {
            return nums.size();
        }
        
        int newArrEndIndex = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[newArrEndIndex]) {
                nums[++newArrEndIndex] = nums[i];
            }
        }
        
        return newArrEndIndex + 1;
    }
    
    // good answers from others
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        for (int n: nums)
            if (!i || n > nums[i-1])
                nums[i++] = n;
        return i;
    }
};
