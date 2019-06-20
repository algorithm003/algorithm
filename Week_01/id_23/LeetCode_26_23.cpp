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
};
