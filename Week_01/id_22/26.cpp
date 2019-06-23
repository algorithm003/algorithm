/*
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) { 
        if(nums.size() == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.size(); ++j) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
};

int main() {
    vector<int> nums = {1, 1, 2, 2};
    
    Solution so;
    int size = so.removeDuplicates(nums);

    for(int i = 0; i < size; ++i) {
        cout << nums[i] << ", ";
    }

    return 0;
}