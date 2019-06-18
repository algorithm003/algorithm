class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() == 0) {
            return 0;
        }
        int ans = 0;
        int max_left = 0, max_right = 0;
        int left_idx = 0, right_idx = height.size() - 1;
        while (left_idx < right_idx) {
            if (height[left_idx] < height[right_idx]) {
                if (max_left > height[left_idx]) {
                    ans += max_left - height[left_idx];
                }
                else {
                    max_left = height[left_idx];
                }
                left_idx++;
            }
            else {
                if (max_right > height[right_idx]) {
                    ans += max_right - height[right_idx];
                }
                else {
                    max_right = height[right_idx];
                }
                right_idx--;
            }
        }
        return ans;
    }
};
