class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> stk;
        int max_area = 0;
        int area = 0;
        int i = 0;
        while (i < heights.size()) {
            if (stk.empty() || heights[stk.top()] <= heights[i]) {
                stk.push(i++);
            } else {
                int top = stk.top();
                stk.pop();
                area = heights[top] * (stk.empty() ? i : (i - stk.top() - 1));
                max_area = (max_area < area) ? area : max_area;
            }
        }
        
        while (!stk.empty()) {
            int top = stk.top();
            stk.pop();
            area = heights[top] * (stk.empty() ? i : (i - stk.top() - 1));
            max_area = (max_area < area) ? area : max_area;
        }
        
        return max_area;
    }
};
