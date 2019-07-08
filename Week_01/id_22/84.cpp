/*
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */

#include <vector>
#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> s;
        int maxArea = 0;
        for(int i = 0; i < heights.size(); ++i) {
            while(!s.empty() && heights[s.top()] >= heights[i]) {
                maxArea = maxArea > heights[s.top()] * (i - s.top()) ? maxArea : heights[s.top()] * (i - s.top());
                s.pop();
            }
            s.push(i);
        }

        return maxArea;
    }
};

int main()
{
    Solution so;
    vector<int> heights = {2, 1, 5, 6, 2, 3};

    int maxArea = so.largestRectangleArea(heights);

    cout << maxArea << endl;

    return 0;
}