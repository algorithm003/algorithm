/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */
class Solution {
public:
    void rotate(vector<int>& nums, int k) {        
        k %= nums.size();
        int baseIndex = 0;
        while (k != 0)
        {
            for (int j = 0; j < k; j++)
                swap(nums[baseIndex + j], nums[j + nums.size() - k]);
            baseIndex += k;            
            k %= nums.size() - baseIndex;
        }
    }
}