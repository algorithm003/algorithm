class Solution {
public:
    int trap(vector<int>& height) {
        int sum = 0;
        stack<int> st;
        for (int i = 0; i < height.size(); i++) {
            while (!st.empty() && height[st.top()] < height[i]) {
                int top = st.top();
                st.pop();
                if (st.empty()) break;
                int w = i - st.top() - 1;
                int h = min(height[i], height[st.top()]) - height[top];
                sum += w * h;
            }
            st.push(i);
        }
        return sum;
    }
};
