//class Solution {
//public:
//    int removeDuplicates(vector<int>& nums) {
//        
//        if (nums.empty())
//            return 0;
//        
//        int last = 0;
//        int size = nums.size();
//        for (int i = 1; i < size; i++)
//        {
//            if (nums[i] != nums[last])
//                nums[++last] = nums[i];
//        }
//        
//        return last+1;    
//    }
//};