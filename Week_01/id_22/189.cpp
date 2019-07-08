/*
 * https://leetcode-cn.com/problems/rotate-array/
 */

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        for(int i = 0; i < nums.size(); ++i) {
            int r = (i + k) % nums.size();
            int tmp = nums[r];
            nums[r] = nums[i];
            nums[i] = tmp;
        }
    }
};

int main() {
    Solution so;
    int k = 3;
    vector<int> nums;
    for (int i = 0; i < 7; ++i) {
        nums[i] = i;
    }

    so.rotate(nums, k);

    return 0;
}